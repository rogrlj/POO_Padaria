CREATE DATABASE sigpDB
GO

USE sigpDB

CREATE TABLE produto(
id		INT				NOT NULL IDENTITY  PRIMARY KEY,
nome	VARCHAR(255)	NOT NULL UNIQUE
)
GO

CREATE TABLE ingrediente(
id			INT				NOT NULL IDENTITY  PRIMARY KEY,
nome		VARCHAR(255)	NOT NULL UNIQUE,
tipoUnit	VARCHAR(20)		NOT NULL
)
GO

CREATE TABLE produto_ingrediente(
produto_id		INT	NOT NULL,
ingrediente_id	INT	NOT NULL,
quantidade		INT	NOT NULL
PRIMARY KEY(produto_id, ingrediente_id)
FOREIGN KEY (produto_id) REFERENCES produto(id),
FOREIGN KEY (ingrediente_id) REFERENCES ingrediente(id)
)
GO

CREATE TABLE estoque(
id				INT	NOT NULL IDENTITY  PRIMARY KEY,
quantidade		INT	NOT NULL,
ingrediente_id	INT	NOT NULL
FOREIGN KEY (ingrediente_id) REFERENCES ingrediente(id)
)
GO

CREATE TABLE historico(
id			INT				NOT NULL IDENTITY  PRIMARY KEY,
acao		VARCHAR(20)		NOT NULL,
quantidade	INT				NOT NULL,
nome		VARCHAR(255)	NOT NULL,
data_acao	DATETIME		NOT NULL
)
GO

DBCC CHECKIDENT ('ingrediente', RESEED, 0)
DBCC CHECKIDENT ('produto', RESEED, 0)

INSERT INTO ingrediente (nome, tipoUnit) VALUES 
('Farinha', 'Kg'),
('Ovo', 'Unidade'),
('Leite', 'Litro'),
('Fermento', 'Kg'),
('Agua', 'Litro'),
('Trigo', 'Kg'),
('Essencia de Baunilha', 'ml'),
('Creme', 'Kg')

INSERT INTO produto (nome) VALUES
('Pão'),
('Bolo'),
('Ovo Frito')

SELECT * FROM ingrediente
SELECT * FROM produto
SELECT * FROM produto_ingrediente
SELECT * FROM estoque

INSERT INTO produto_ingrediente (produto_id, ingrediente_id, quantidade) VALUES
(1, 1, 2),
(1, 2, 2),
(1, 5, 1),
(2, 1, 2),
(2, 7, 15),
(2, 2, 3),
(3, 2, 2)

INSERT INTO estoque (quantidade, ingrediente_id) VALUES
(1000, 1),
(1000, 2),
(500, 3),
(50, 4)

SELECT ping.ingrediente_id, i.nome, ping.quantidade 
FROM ingrediente i, produto_ingrediente ping
WHERE i.id = ping.ingrediente_id



