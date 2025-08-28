-- COMENTANDO!!!
/* 
COMENTARIO MULTIPLAS LINHAS 
*/

SET search_path TO clinica;

-- DDL - CRIAR - CREATE (SCHEMA, TABELA)
CREATE SCHEMA clinica IF NOT EXISTS;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE clinica.medico (
	-- INFORMAR COLUNAS
	-- NOME_DA_COLUNA TIPO_DE_DADO
	-- PRIMARY KEY - CHAVE PRIMARIA 
	-- GENERATED ALWAYS AS IDENTITY - A CHAVE SERA GERADA AUTOMATICAMENTE
	id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	crm TEXT NOT NULL,
	especialidade TEXT NOT NULL
);

CREATE TABLE clinica.paciente (
	id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	idade INT NOT NULL,
	data_nascimento DATE NOT NULL
);

CREATE TABLE clinica.clinica (
	id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	endereco TEXT 
);

CREATE TABLE clinica.consulta (
	id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	data TIMESTAMPTZ NOT NULL,
	valor NUMERIC (10, 4),
	--maneira extensa
	id_medico INT NOT NULL,
	FOREIGN KEY (id_medico) 
	REFERENCES clinica.medico(id_medico),
	--maneira abreviada
	id_clinica INT NOT NULL REFERENCES clinica.clinica(id_clinica),
	id_paciente INT NOT NULL REFERENCES clinica.paciente(id_paciente)
);

-- TRUNCATE - LIMPA A TABELA
TRUNCATE TABLE clinica.consulta RESTART IDENTITY;

-- ALTER - ALTERAR TABELA
ALTER TABLE clinica.paciente ADD COLUMN cpf VARCHAR(14) UNIQUE;
-- UNIQUE IMPEDE CADASTRO REPETIDO

-- APAGAR COLUNA
ALTER TABLE clinica.paciente
DROP COLUMN cpf;

-- RENOMEAR TABELA
ALTER TABLE clinica.paciente
RENAME TO novopaciente;

-- APAGAR TABELA - DROP
/*
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;
*/

