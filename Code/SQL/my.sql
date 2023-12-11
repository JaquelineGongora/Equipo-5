create database ec;  /*Crear base*/

use ec;  /* Usar Base de datos*/

/*Crear tabla*/

CREATE TABLE Ciberseguridad(
    id INT AUTO_INCREMENT PRIMARY KEY,
	matricula VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    calif1 INT DEFAULT 0,
    calif2 INT DEFAULT 0,
    calif3 INT DEFAULT 0,
    calif4 INT DEFAULT 0,
    final INT DEFAULT 0
);

CREATE TABLE Usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    contrasenia VARCHAR(50) NOT NULL,
	permiso INT NOT NULL
);

/*Insertar usuarios*/

INSERT INTO Usuarios(usuario, contrasenia, permiso)
VALUES ( 'EducacionContinua', 'edu2023', 1);

INSERT INTO Usuarios(usuario, contrasenia, permiso)
VALUES ( 'MauroKuh', '12344', 2);

show tables;
/*Insertar Datos*/
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '19200637', 'Mauro Kuh Esquivel');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '1920088', 'Mariana Gonzalez Canul');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '19200230', 'Jaqueline Gongora Tun');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '2202020', 'Isaias Rodriguez Rosado');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '219292', 'Jose Luis Lara');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '19292929', 'Jesus Kuh Esquivel');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '220303', 'Julio Alcocer Duran');
INSERT INTO Ciberseguridad(matricula, nombre)
VALUES ( '219292', 'Johan Alvares Llanos');

/*Mostrar Datos*/
select * from Ciberseguridad;
/*Modificar Datos*/
UPDATE tablaEstudiantes SET calificacion = 80 WHERE id = 4;
