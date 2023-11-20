
create database EducacionContinua; /Crear Base de datos/

use EducacionContinua;

CREATE TABLE tablaEstudiantes(
    id INT AUTO_INCREMENT PRIMARY KEY,
	matricula VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    calificacion INT NOT NULL,
);

show tables;
INSERT INTO tablaEstudiantes(matricula, nombre, apellido, calificacion)
VALUES ( 'a19203622', 'Jaqueline', 'Góngora Tun', 10);
INSERT INTO tablaEstudiantes(matricula, nombre, apellido, calificacion)
VALUES ( 'a19201105', 'Mariana Estefanía', 'González Canul', 10);
INSERT INTO tablaEstudiantes(matricula, nombre, apellido, calificacion)
VALUES ( 'a19198913', 'Mauro Arif', 'Kuh Esquivel', 10);

select * from tablaEstudiantes;
