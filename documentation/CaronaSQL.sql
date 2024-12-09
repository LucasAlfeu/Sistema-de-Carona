CREATE DATABASE IF NOT EXISTS sistema_de_carona;

USE sistema_de_carona;

CREATE TABLE IF NOT EXISTS Usuario (
    ID_usuario INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS Automovel (
    ID_automovel INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(20) NOT NULL UNIQUE,
    modelo VARCHAR(50) NOT NULL,
    cor VARCHAR(20) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    fk_Usuario_ID_usuario INT NOT NULL,
    FOREIGN KEY (fk_Usuario_ID_usuario) REFERENCES Usuario(ID_usuario)
);

CREATE TABLE IF NOT EXISTS Carona (
    ID_carona INT PRIMARY KEY AUTO_INCREMENT,
    saida VARCHAR(50) NOT NULL,
    chegada VARCHAR(50) NOT NULL,
    dataCarona VARCHAR(20) NOT NULL,
    horario VARCHAR(5) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    vagas INT NOT NULL,
    carro VARCHAR(20),
    fk_Usuario_ID_usuario INT NOT NULL,
    FOREIGN KEY (fk_Usuario_ID_usuario) REFERENCES Usuario(ID_usuario)
);

CREATE TABLE IF NOT EXISTS Pedido (
    ID_Pedido INT PRIMARY KEY AUTO_INCREMENT,
    embarque VARCHAR(100) NOT NULL,
    desembarque VARCHAR(100) NOT NULL,
    data DATE NOT NULL,
    vagasDesejadas INT NOT NULL,
    confirmado VARCHAR(20) NOT NULL,
    fk_Usuario_ID_usuario INT NOT NULL,
    fk_Carona_ID_Carona INT NOT NULL,
    FOREIGN KEY (fk_Usuario_ID_usuario) REFERENCES Usuario(ID_usuario),
    FOREIGN KEY (fk_Carona_ID_Carona) REFERENCES Carona(ID_Carona)
);
