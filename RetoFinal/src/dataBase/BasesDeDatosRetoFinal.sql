create database laLiga;
use laLiga;

create table equipo(
nombreEquipo varchar(30) primary key,
titulos integer,
nombreEstadio varchar(30)
);

create table partidos(
fechaInicio datetime primary key,
resultado varchar(3)
);

create table juegan(
nombreEquipoLocal varchar(30),
nombreEquipoVisitante varchar(30),
fechaInicio datetime,
primary key(nombreEquipoLocal, nombreEquipoVisitante, fechaInicio),
foreign key (nombreEquipoLocal) references equipo(nombreEquipo) on delete cascade,
foreign key (nombreEquipoVisitante) references equipo(nombreEquipo)on delete cascade,
foreign key (fechaInicio) references partidos(fechaInicio)on delete cascade
);


create table jugador(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
dorsal integer(2),
numeroGoles integer(3),
numeroAsistencias integer(3),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade
);

create table entrenador(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
tipoEntrenador enum('PrimerEntrenador', 'SegundoEntrenador'),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade
);

INSERT INTO equipo 
VALUES
("Barcelona",3,"Camp Nou"),
("MAdrid",5,"Santiago Bernabeu");


