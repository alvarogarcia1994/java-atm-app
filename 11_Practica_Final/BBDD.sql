CREATE DATABASE IF NOT EXISTS atm;

USE atm;

CREATE TABLE IF NOT EXISTS clientes(
	ID INT(3) NOT NULL AUTO_INCREMENT,
	Username VARCHAR(760),
	PIN INT(4),
	PRIMARY KEY ID (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS cuenta(
	ID INT(5) NOT NULL AUTO_INCREMENT,
	ID_Cliente BIGINT(20) NOT NULL,
	Saldo FLOAT(7,2),
	tipo VARCHAR(80),
	PRIMARY KEY ID (ID),
	KEY ID_Cliente(ID_Cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
