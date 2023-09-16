DROP DATABASE IF EXISTS moschoubank;

CREATE DATABASE moschoubank;

USE moschoubank;

CREATE TABLE users(
	cardNumber INT PRIMARY KEY,
    pin INT NOT NULL,
    balance INT NOT NULL
);

INSERT INTO users VALUES
(11111, 1234, 500),
(22222, 9999, 1000);