-- DML (DATA MANIPULATION LANGUAGE)
-- INSERT (CADASTRAR)
-- UPDATE (ATUALIZAR)
-- DELETE (APAGAR)

-- OPCIONAL
-- SET search_path TO clinica; >> comando para nao ter que escrever ou chamar o SCHEMA TODA HORA PARA CRIAR TABELAS
-- EXEMPLO: clinica.paciente -> paciente

-- INSERT INTO <SCHEMA>.<TABELA>
INSERT INTO clinica.medico(nome, especialidade, crm) VALUES
('Vinicio', 'Ortopedia', '123456'),
('Ariel', 'Cardiologia', '654321')

-- DQL (DATA QUERY LANGUAGE) - LINGUAGEM DE CONSULTA DE DADOS
-- SELECT 
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.novopaciente(nome, idade, data_nascimento) VALUES 
('Fulano', 23, '2002-07-20')

SELECT * FROM clinica.novopaciente;

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES 
('Clinica Sao Caetano', 'A clinica do ABC', 'Rua Niteroi')

SELECT * FROM clinica.clinica;

INSERT INTO clinica.consulta(data, valor, id_medico, id_clinica, id_paciente) VALUES
('2025-08-28 09:30:00-03', 350.45, 1, 1, 1)

SELECT * FROM clinica.consulta;

-- UPDATE 
UPDATE clinica.consulta
SET valor = 200.50
WHERE id_consulta = 1;

UPDATE clinica.consulta
SET valor = 530
WHERE valor > 500 AND 1000;
-- OR 

-- DELETE 
DELETE FROM clinica.medico
WHERE id_medico = 2; 
