create database laLiga;
use laLiga;

create table usuario(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
icon blob
);

create table equipo(
nombreEquipo varchar(30) primary key,
titulos integer unsigned,
nombreEstadio varchar(30),
logo blob
);

create table juegan(
nombreEquipoLocal varchar(30),
nombreEquipoVisitante varchar(30),
fechaInicio datetime primary key,
resultado varchar(3),
foreign key (nombreEquipoLocal) references equipo(nombreEquipo) on delete cascade,
foreign key (nombreEquipoVisitante) references equipo(nombreEquipo)on delete cascade
);


create table jugador(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
dorsal integer(2),
numeroGoles integer(3) unsigned,
numeroAsistencias integer(3) unsigned,
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade,
icon blob
);

create table entrenador(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
tipoEntrenador enum('Primer_entrenador', 'Segundo_entrenador'),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade,
icon blob
);

insert into equipo values('Athletic de Bilbao',100,'San Mames');
insert into entrenador values('entrenador','1234','1','PrimerEntrenador','Athletic de Bilbao');
insert into jugador values('jugador','1234','1',9,99,500,'Athletic de Bilbao');
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 1000, 'Camp Nou');
INSERT INTO jugador (user, password, tipo, dorsal, numeroGoles, numeroAsistencias, nombreEquipo)
VALUES ('alder', 'alder', 'jugador', 10, 0, 0, 'Barsa');