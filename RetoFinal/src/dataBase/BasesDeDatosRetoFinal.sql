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
<<<<<<< HEAD


insert into equipo values('Athletic de Bilbao',100,'San Mames');

insert into entrenador values('entrenador','1234','1','Primer_entrenador','Athletic de Bilbao');

insert into entrenador values('entrenador','1234','1','PrimerEntrenador','Athletic de Bilbao');

insert into jugador values('jugador','1234','1',9,99,500,'Athletic de Bilbao');

INSERT INTO entrenador (user, password, tipo, tipoEntrenador, nombreEquipo) VALUES ('borja', '1234', '1', 'Primer_entrenador', 'Athletic de Bilbao');
select * from equipo;
insert into equipo (nombreEquipo,titulos,nombreEstadio) values('Athletic de Bilbao',100,'San Mames');
insert into entrenador values('entrenador','1234','1','PrimerEntrenador','Athletic de Bilbao');
insert into jugador (user,password ,tipo ,dorsal ,numeroGoles ,numeroAsistencias  ,nombreEquipo) values('jugador','1234jugador','1',9,99,500,'Athletic de Bilbao');
=======

insert into equipo(nombreEquipo, titulos, nombreEstadio) values('Athletic de Bilbao',100,'San Mames');
insert into entrenador(user, password, tipo, tipoEntrenador, nombreEquipo) values('entrenador','1234','entrenador','Primer_entrenador','Athletic de Bilbao');
insert into jugador (user, password, tipo, dorsal, numeroGoles, numeroAsistencias, nombreEquipo) values('jugador','1234','1',9,999,500,'Athletic de Bilbao');
>>>>>>> Enzo
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 1000, 'Camp Nou');
INSERT INTO jugador (user, password, tipo, dorsal, numeroGoles, numeroAsistencias, nombreEquipo)
VALUES ('alder', 'alder', 'jugador', 10, 0, 0, 'Barsa');
UPDATE juegan SET fechaInicio = '2024-04-03 10:00:00', resultado = '3-0' WHERE fechaInicio = '2024-05-01 10:00:01';
select * from juegan;