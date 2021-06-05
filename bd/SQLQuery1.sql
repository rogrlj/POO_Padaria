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
