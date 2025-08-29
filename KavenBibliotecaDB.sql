drop database if exists kavenLibreriaDB;
create database kavenLibreriaDB;
use kavenLibreriaDB;

create table Generos(
	id_genero int not null auto_increment,
    tipo_genero  varchar(64) not null,
    descripcion_genero varchar (255) not null,
	constraint pk_Generos primary key (id_genero)  
);

create table Ubicacion (
	id_ubicacion int not null auto_increment,
    edificio varchar(64) not null,
	sala varchar(64) not null,
	estante varchar(64) not null,
	fila varchar(64) not null,
	columna varchar(64) not null,
	constraint pk_Ubicacion primary key (id_ubicacion)  
);

create table Libros (
	id_libro int not null auto_increment,
    id_genero int not null,
    id_ubicacion int not null,
    titulo varchar(255) not null,
    autor varchar(64) not null,
    cantidad int not null,
    constraint pk_libros primary key (id_libro),
    constraint fk_libros_generos foreign key (id_genero)
		references Generos (id_genero),
	constraint fk_libros_ubicacion foreign key (id_ubicacion)
		references Ubicacion (id_ubicacion)    
    on delete cascade    
);

insert into Generos (tipo_genero, descripcion_genero) values
('Accion', 'Películas de acción con mucha adrenalina y adrenalina.'),
('Drama', 'Películas dramáticas que tocan temas profundos de la vida.'),
('Comedia', 'Películas que buscan hacer reír al público.'),
('Terror', 'Películas que buscan asustar y crear tensión.'),
('Ciencia Ficción', 'Películas que exploran futuros tecnológicos y mundos imaginarios.');

insert into Ubicacion (edificio, sala, estante, fila, columna) values
('Edificio A', 'Sala 1', 'Estante 3', 'Fila 1', 'Columna 2'),
('Edificio B', 'Sala 2', 'Estante 4', 'Fila 2', 'Columna 3'),
('Edificio C', 'Sala 3', 'Estante 1', 'Fila 3', 'Columna 4'),
('Edificio D', 'Sala 4', 'Estante 2', 'Fila 4', 'Columna 1'),
('Edificio E', 'Sala 5', 'Estante 5', 'Fila 5', 'Columna 5');

insert into Libros (id_genero, id_ubicacion, titulo, autor, cantidad) values
(1, 1, 'Acción en la ciudad', 'Juan Pérez', 20),
(2, 2, 'El drama del amor', 'Ana García', 15),
(3, 3, 'Risas y carcajadas', 'Carlos López', 30),
(4, 4, 'Noche de terror', 'María Rodríguez', 25),
(5, 5, 'Futuro desconocido', 'Luis Martínez', 10);

select * from Libros;
select * from Generos;
select * from Ubicacion;
