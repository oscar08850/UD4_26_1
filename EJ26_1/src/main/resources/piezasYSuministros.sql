DROP DATABASE IF EXISTS piezasYSuministros;
CREATE DATABASE piezasYSuministros;

USE piezasYSuministros;


DROP TABLE IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores;
DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS usuario;

 
CREATE TABLE piezas (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(100)
);



CREATE TABLE proveedores (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(100)
);



CREATE TABLE suministra (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  codigo_pieza int,
  id_proveedor int,
  precio int,
  FOREIGN KEY (codigo_pieza) REFERENCES piezas (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_proveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE usuario (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username varchar(300) NOT NULL,
  password varchar(300) NOT NULL,
  role varchar(100) NOT NULL DEFAULT 'user'
)


INSERT INTO piezas (nombre) VALUES
	("Pieza1"),
    ("Pieza2"),
    ("Pieza3"),
    ("Pieza4"),
    ("Pieza5");
    
    
INSERT INTO proveedores (nombre) VALUES
	("Proveedor1"),
    ("Proveedor2"),
    ("Proveedor3"),
    ("Proveedor4"),
    ("Proveedor5");
   
    
INSERT INTO suministra (codigo_pieza, id_proveedor, precio) VALUES
	(1, 1, 100),
    (2, 2, 200),
    (3, 3, 300),
    (4, 4, 400),
    (5, 5, 500);
    

INSERT INTO usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');
