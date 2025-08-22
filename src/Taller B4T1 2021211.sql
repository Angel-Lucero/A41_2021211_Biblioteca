drop database if exists kavenLibreriaDB;
create database kavenLibreriaDB;
use kavenLibreriaDB;



create table Generos(
	idGenero int not null auto_increment,
    tipoGenero  varchar(64) not null,
    descripcionGenero varchar (255) not null,
	constraint pk_Generos primary key (idGenero)  
);

create table Ubicacion (
	idUbicacion int not null auto_increment,
    edificio varchar(64) not null,
	sala varchar(64) not null,
	estante varchar(64) not null,
	fila varchar(64) not null,
	columa varchar(64) not null,
	constraint pk_Ubicacion primary key (idUbicacion)  
);

create table Libros (
	idLibro int not null auto_increment,
    idGenero int not null,
    idUbicacion int not null,
    titulo varchar(255) not null,
    autor varchar(64) not null,
    cantidad int not null,
    constraint pk_libros primary key (idLibro),
    constraint fk_libros_generos foreign key (idGenero)
		references Generos (idGenero),
	constraint fk_libros_ubicacion foreign key (idUbicacion)
		references Ubicacion (idUbicacion)    
    on delete cascade    
);



insert into Generos (tipoGenero, descripcionGenero)
values ('Accion','sdrcfgvbhnjfrdftyguh');

insert into Ubicacion (edificio, sala, estante, fila, columa)
values ('a','a','a','a','a');

insert into Libros (idGenero, idUbicacion, titulo, autor,cantidad)
values	(1,1,'a','a',15);

select * from Libros;
select * from Generos;
select * from Ubicacion;
