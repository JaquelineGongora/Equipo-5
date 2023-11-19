/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  mauro
 * Created: 12 nov 2023
 */

create database db_tienda;

use db_tienda;

CREATE TABLE tablaTienda(
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    precio INT NOT NULL
);
show tables;

INSERT INTO tablaTienda(codigo, nombre,  precio)
VALUES ( '2233', 'Chicle', 2);
INSERT INTO tablaTienda(codigo, nombre,  precio)
VALUES ( '3728', 'Galleta', 4);

select * from tablaTienda;
