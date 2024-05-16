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
assistsUpdated BOOLEAN DEFAULT FALSE,
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
foreign key (user) references usuario(user) on delete cascade,
icon blob
);

create table entrenador(
user varchar(20) primary key,
tipoEntrenador enum('Primer_entrenador', 'Segundo_entrenador'),
nombreEquipo varchar(30),
foreign key (nombreEquipo) references equipo(nombreEquipo) on delete cascade,
foreign key (user) references usuario(user) on delete cascade,
icon blob
);


