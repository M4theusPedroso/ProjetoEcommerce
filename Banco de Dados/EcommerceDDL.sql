-- COMENTANDO!!!
/* 
COMENTARIO MULTIPLAS LINHAS 
*/

-- DDL - CRIAR - CREATE (SCHEMA, TABELA)
CREATE SCHEMA ecommerce;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE ecommerce.cliente (
	-- INFORMAR COLUNAS
	-- NOME_DA_COLUNA TIPO_DE_DADO
	-- PRIMARY KEY - CHAVE PRIMARIA 
	-- GENERATED ALWAYS AS IDENTITY - A CHAVE SERA GERADA AUTOMATICAMENTE
	cliente_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	email TEXT NOT NULL,
	senha TEXT NOT NULL,
	telefone TEXT NOT NULL,
	data_cadastro TIMESTAMPTZ
);

CREATE TABLE ecommerce.pedido (
	pedido_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	cliente_id INT NOT NULL,
	FOREIGN KEY (cliente_id) 
	REFERENCES ecommerce.cliente(cliente_id),
	data_pedido TIMESTAMPTZ,
	valor_total NUMERIC(18, 4) NOT NULL,
	status TEXT NOT NULL
);

CREATE TABLE ecommerce.produto (
	produto_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_produto TEXT NOT NULL,
	descricao TEXT NOT NULL,
	preco INT NOT NULL,
	estoque_disponivel INT NOT NULL,
	imagem_URL TEXT NOT NULL
);

CREATE TABLE ecommerce.item_pedido (
	item_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	pedido_id INT NOT NULL,
	FOREIGN KEY (pedido_id) 
	REFERENCES ecommerce.pedido(pedido_id),

	produto_id INT NOT NULL,
	FOREIGN KEY (produto_id) 
	REFERENCES ecommerce.produto(produto_id),

	quantidade INT NOT NULL
);

CREATE TABLE ecommerce.pagamento (
	pagamento_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	
	pedido_id INT NOT NULL,
	FOREIGN KEY (pedido_id) 
	REFERENCES ecommerce.pedido(pedido_id),
	
	forma_pagamento TEXT NOT NULL,
	status TEXT NOT NULL,
	data_pagamento TIMESTAMPTZ
);




