DROP DATABASE IF EXISTS Senderismo;
CREATE DATABASE Senderismo;
USE Senderismo;
CREATE TABLE Ruta( 
	id_ruta INT PRIMARY KEY,
	nombreRuta VARCHAR(40), 
	poblacion VARCHAR(40),
	recorrido INT,
	desnivel INT,
	tiempo INT,
	dificultad VARCHAR(40),
	imagen BLOB
);