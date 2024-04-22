
create database laLiga;
use laLiga;

create table usuario(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10)
);

create table equipo(
nombreEquipo varchar(30) primary key,
titulos integer,
nombreEstadio varchar(30)
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
numeroGoles integer(3),
numeroAsistencias integer(3),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade
);

create table entrenador(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
tipoEntrenador enum('Primer_entrenador', 'Segundo_entrenador'),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade
);




insert into equipo values('Athletic de Bilbao',100,'San Mames');
insert into entrenador values('entrenador','1234','1','Primer_Entrenador','Athletic de Bilbao');
insert into jugador values('jugador','1234','1',9,99,500,'Athletic de Bilbao');
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 0, 'Camp Nou');

select * from equipo;
select * from entrenador;


insert into equipo values('Athletic de Bilbao',100,'San Mames');
insert into entrenador values('entrenador','1234','1','PrimerEntrenador','Athletic de Bilbao');
insert into jugador values('jugador','1234','1',9,99,500,'Athletic de Bilbao');
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 0, 'Camp Nou');



INSERT INTO jugador (user, password, tipo, dorsal, numeroGoles, numeroAsistencias, nombreEquipo)
VALUES ('alder', 'alder', 'jugador', 10, 0, 0, 'Barsa');

select * from laliga.jugador;

select * from laliga.jugador where dorsal = 10 AND nombreEquipo = 'Barsa';


select * from laliga.jugador;
select * from laliga.jugador where dorsal = 10 AND nombreEquipo = 'Barsa';

SELECT * FROM juegan;

select * from laliga.jugador where dorsal = 10 AND nombreEquipo = 'Barsa';

create database laLiga;
use laLiga;

create table equipo(
nombreEquipo varchar(30) primary key,
titulos integer,
nombreEstadio varchar(30)
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
numeroGoles integer(3),
numeroAsistencias integer(3),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade
);

create table entrenador(
user varchar(20) primary key,
password varchar(20),
tipo varchar(10),
tipoEntrenador enum('Primer_entrenador', 'Segundo_entrenador'),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade
);

drop table entrenador;


insert into equipo values('Athletic de Bilbao',100,'San Mames');
insert into entrenador values('entrenador','1234','1','PrimerEntrenador','Athletic de Bilbao');
insert into jugador values('jugador','1234','1',9,99,500,'Athletic de Bilbao');
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 0, 'Camp Nou');

select * from equipo;
select * from entrenador;
insert into entrenador values('entrenador','1234','1','Primer_entrenador','Athletic de Bilbao');

alter table equipo add logo blob;
alter table jugador add icon blob;
insert into equipo values('Athletic de Bilbao',100,'San Mames');
insert into entrenador values('entrenador','1234','1','PrimerEntrenador','Athletic de Bilbao');
insert into jugador values('jugador','1234','1',9,99,500,'Athletic de Bilbao');
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio) VALUES ('Barsa', 0, 'Camp Nou');



INSERT INTO jugador (user, password, tipo, dorsal, numeroGoles, numeroAsistencias, nombreEquipo)
VALUES ('alder', 'alder', 'jugador', 10, 0, 0, 'Barsa');

select * from laliga.jugador;

select * from laliga.jugador where dorsal = 10 AND nombreEquipo = 'Barsa';


select * from laliga.jugador;
select * from laliga.jugador where dorsal = 10 AND nombreEquipo = 'Barsa';

SELECT * FROM juegan;

select * from laliga.jugador where dorsal = 10 AND nombreEquipo = 'Barsa';

