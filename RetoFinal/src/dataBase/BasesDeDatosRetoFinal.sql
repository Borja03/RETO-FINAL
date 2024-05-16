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
resultado varchar(3) default '0-0',
foreign key (nombreEquipoLocal) references equipo(nombreEquipo) on delete cascade,
foreign key (nombreEquipoVisitante) references equipo(nombreEquipo)on delete cascade
);


create table jugador(
user varchar(20) primary key,
dorsal integer(2),
numeroGoles integer(3) unsigned,
numeroAsistencias integer(3) unsigned,
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade,
foreign key (user) references usuario(user) on delete cascade
);

create table entrenador(
user varchar(20) primary key,
tipoEntrenador enum('Primer_entrenador', 'Segundo_entrenador'),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade,
foreign key (user) references usuario(user) on delete cascade
);

insert into equipo(nombreEquipo, titulos, nombreEstadio) values('Athletic de Bilbao',100,'San Mames');

-- Insertar usuario para el entrenador
insert into usuario(user, password, tipo) values('entrenador','1234','entrenador');
insert into entrenador(user, tipoEntrenador, nombreEquipo) values('entrenador','Primer_entrenador','Athletic de Bilbao');

-- Insertar usuario para el jugador
insert into usuario(user, password, tipo) values('jugador','1234','jugador');
insert into jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo) values('jugador',9,999,500,'Athletic de Bilbao');

INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 1000, 'Camp Nou');

-- Insertar usuario para el jugador de Barsa
insert into usuario(user, password, tipo) values('alder','alder','jugador');
INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo)
VALUES ('alder', 10, 0, 0, 'Barsa');

UPDATE juegan SET fechaInicio = '2024-04-03 10:00:00', resultado = '3-0' WHERE fechaInicio = '2024-05-01 10:00:01';
select * from juegan;