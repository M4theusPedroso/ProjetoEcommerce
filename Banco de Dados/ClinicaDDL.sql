-- COMENTANDO!!!
/* 
COMENTARIO MULTIPLAS LINHAS 
*/

-- DDL - CRIAR - CREATE (SCHEMA, TABELA)
CREATE SCHEMA clinica;

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
	id_medico INT NOT NULL,
	--maneira extensa
	FOREIGN KEY (id_medico) 
	REFERENCES clinica.medico(id_medico),
	--maneira abreviada
	id_clinica INT NOT NULL REFERENCES clinica.clinica(id_clinica),
	id_paciente INT NOT NULL REFERENCES clinica.paciente(id_paciente)
)