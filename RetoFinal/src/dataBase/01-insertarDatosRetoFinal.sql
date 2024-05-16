-- Use the laLiga database
USE laLiga;

-- Insert data into the equipo table
INSERT INTO equipo (nombreEquipo, titulos, nombreEstadio, logo) VALUES 
('Athletic de Bilbao', 8, 'San Mamés', NULL),
('Real Madrid', 35, 'Santiago Bernabéu', NULL),
('Barcelona', 26, 'Camp Nou', NULL),
('Atletico Madrid', 11, 'Wanda Metropolitano', NULL),
('Sevilla', 1, 'Ramón Sánchez Pizjuán', NULL);

-- Insert data into the usuario, jugador, and entrenador tables
-- Athletic de Bilbao players and coaches
INSERT INTO usuario (user, password, tipo, icon) VALUES
('ikerm', '1234', 'jugador', NULL),
('inigom', '1234', 'jugador', NULL),
('unais', '1234', 'jugador', NULL),
('mikelb', '1234', 'jugador', NULL),
('oscard', '1234', 'jugador', NULL),
('raulg', '1234', 'jugador', NULL),
('yeraya', '1234', 'jugador', NULL),
('danig', '1234', 'jugador', NULL),
('ikera', '1234', 'jugador', NULL),
('alexr', '1234', 'jugador', NULL),
('mikelv', '1234', 'jugador', NULL),
('inakiw', '1234', 'jugador', NULL),
('marcelinog', '1234', 'entrenador', NULL),
('patxis', '1234', 'entrenador', NULL);

INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo, icon) VALUES
('ikerm', 1, 2, 1, 'Athletic de Bilbao', NULL),
('inigom', 2, 1, 0, 'Athletic de Bilbao', NULL),
('unais', 3, 3, 2, 'Athletic de Bilbao', NULL),
('mikelb', 4, 0, 1, 'Athletic de Bilbao', NULL),
('oscard', 5, 4, 0, 'Athletic de Bilbao', NULL),
('raulg', 6, 2, 3, 'Athletic de Bilbao', NULL),
('yeraya', 7, 1, 1, 'Athletic de Bilbao', NULL),
('danig', 8, 0, 4, 'Athletic de Bilbao', NULL),
('ikera', 9, 5, 2, 'Athletic de Bilbao', NULL),
('alexr', 10, 3, 3, 'Athletic de Bilbao', NULL),
('mikelv', 11, 4, 1, 'Athletic de Bilbao', NULL),
('inakiw', 12, 2, 0, 'Athletic de Bilbao', NULL);

INSERT INTO entrenador (user, tipoEntrenador, nombreEquipo, icon) VALUES
('marcelinog', 'Primer_entrenador', 'Athletic de Bilbao', NULL),
('patxis', 'Segundo_entrenador', 'Athletic de Bilbao', NULL);

-- Real Madrid players and coaches
INSERT INTO usuario (user, password, tipo, icon) VALUES
('thibautc', '1234', 'jugador', NULL),
('danic', '1234', 'jugador', NULL),
('ederm', '1234', 'jugador', NULL),
('davida', '1234', 'jugador', NULL),
('lukam', '1234', 'jugador', NULL),
('casemiro', '1234', 'jugador', NULL),
('tonik', '1234', 'jugador', NULL),
('karimb', '1234', 'jugador', NULL),
('viniciusj', '1234', 'jugador', NULL),
('rodrygog', '1234', 'jugador', NULL),
('marcoa', '1234', 'jugador', NULL),
('edenh', '1234', 'jugador', NULL),
('carloa', '1234', 'entrenador', NULL),
('davidea', '1234', 'entrenador', NULL);

INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo, icon) VALUES
('thibautc', 1, 0, 0, 'Real Madrid', NULL),
('danic', 2, 1, 2, 'Real Madrid', NULL),
('ederm', 3, 2, 1, 'Real Madrid', NULL),
('davida', 4, 0, 3, 'Real Madrid', NULL),
('lukam', 5, 3, 2, 'Real Madrid', NULL),
('casemiro', 6, 2, 0, 'Real Madrid', NULL),
('tonik', 7, 4, 3, 'Real Madrid', NULL),
('karimb', 8, 5, 4, 'Real Madrid', NULL),
('viniciusj', 9, 6, 2, 'Real Madrid', NULL),
('rodrygog', 10, 1, 1, 'Real Madrid', NULL),
('marcoa', 11, 2, 3, 'Real Madrid', NULL),
('edenh', 12, 3, 0, 'Real Madrid', NULL);

INSERT INTO entrenador (user, tipoEntrenador, nombreEquipo, icon) VALUES
('carloa', 'Primer_entrenador', 'Real Madrid', NULL),
('davidea', 'Segundo_entrenador', 'Real Madrid', NULL);

-- Barcelona players and coaches
INSERT INTO usuario (user, password, tipo, icon) VALUES
('marcat', '1234', 'jugador', NULL),
('gerardp', '1234', 'jugador', NULL),
('sergiob', '1234', 'jugador', NULL),
('jordia', '1234', 'jugador', NULL),
('frenkied', '1234', 'jugador', NULL),
('pedrig', '1234', 'jugador', NULL),
('ansuf', '1234', 'jugador', NULL),
('ousmaned', '1234', 'jugador', NULL),
('memphisd', '1234', 'jugador', NULL),
('pierreap', '1234', 'jugador', NULL),
('gavip', '1234', 'jugador', NULL),
('serginod', '1234', 'jugador', NULL),
('xavih', '1234', 'entrenador', NULL),
('oscarh', '1234', 'entrenador', NULL);

INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo, icon) VALUES
('marcat', 1, 0, 0, 'Barcelona', NULL),
('gerardp', 2, 2, 1, 'Barcelona', NULL),
('sergiob', 3, 1, 3, 'Barcelona', NULL),
('jordia', 4, 3, 2, 'Barcelona', NULL),
('frenkied', 5, 2, 1, 'Barcelona', NULL),
('pedrig', 6, 4, 4, 'Barcelona', NULL),
('ansuf', 7, 5, 3, 'Barcelona', NULL),
('ousmaned', 8, 1, 0, 'Barcelona', NULL),
('memphisd', 9, 3, 1, 'Barcelona', NULL),
('pierreap', 10, 4, 2, 'Barcelona', NULL),
('gavip', 11, 2, 3, 'Barcelona', NULL),
('serginod', 12, 0, 0, 'Barcelona', NULL);

INSERT INTO entrenador (user, tipoEntrenador, nombreEquipo, icon) VALUES
('xavih', 'Primer_entrenador', 'Barcelona', NULL),
('oscarh', 'Segundo_entrenador', 'Barcelona', NULL);

-- Atletico Madrid players and coaches
INSERT INTO usuario (user, password, tipo, icon) VALUES
('jano', '1234', 'jugador', NULL),
('kierant', '1234', 'jugador', NULL),
('stefans', '1234', 'jugador', NULL),
('josemg', '1234', 'jugador', NULL),
('renanl', '1234', 'jugador', NULL),
('koker', '1234', 'jugador', NULL),
('thomasl', '1234', 'jugador', NULL),
('yannickc', '1234', 'jugador', NULL),
('luiss', '1234', 'jugador', NULL),
('joaof', '1234', 'jugador', NULL),
('marcosl', '1234', 'jugador', NULL),
('angelc', '1234', 'jugador', NULL),
('diegos', '1234', 'entrenador', NULL),
('nelsonv', '1234', 'entrenador', NULL);

INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo, icon) VALUES
('jano', 1, 0, 0, 'Atletico Madrid', NULL),
('kierant', 2, 2, 1, 'Atletico Madrid', NULL),
('stefans', 3, 1, 0, 'Atletico Madrid', NULL),
('josemg', 4, 3, 2, 'Atletico Madrid', NULL),
('renanl', 5, 2, 1, 'Atletico Madrid', NULL),
('koker', 6, 4, 3, 'Atletico Madrid', NULL),
('thomasl', 7, 5, 4, 'Atletico Madrid', NULL),
('yannickc', 8, 6, 2, 'Atletico Madrid', NULL),
('luiss', 9, 1, 1, 'Atletico Madrid', NULL),
('joaof', 10, 2, 3, 'Atletico Madrid', NULL),
('marcosl', 11, 3, 0, 'Atletico Madrid', NULL),
('angelc', 12, 4, 2, 'Atletico Madrid', NULL);

INSERT INTO entrenador (user, tipoEntrenador, nombreEquipo, icon) VALUES
('diegos', 'Primer_entrenador', 'Atletico Madrid', NULL),
('nelsonv', 'Segundo_entrenador', 'Atletico Madrid', NULL);

-- Sevilla players and coaches
INSERT INTO usuario (user, password, tipo, icon) VALUES
('yassineb', '1234', 'jugador', NULL),
('jesusn', '1234', 'jugador', NULL),
('diegoac', '1234', 'jugador', NULL),
('karims', '1234', 'jugador', NULL),
('joanjo', '1234', 'jugador', NULL),
('fernandor', '1234', 'jugador', NULL),
('papeg', '1234', 'jugador', NULL),
('lukedj', '1234', 'jugador', NULL),
('erikl', '1234', 'jugador', NULL),
('lucasd', '1234', 'jugador', NULL),
('rafaelmir', '1234', 'jugador', NULL),
('youssefen', '1234', 'jugador', NULL),
('julenl', '1234', 'entrenador', NULL),
('pablov', '1234', 'entrenador', NULL);

INSERT INTO jugador (user, dorsal, numeroGoles, numeroAsistencias, nombreEquipo, icon) VALUES
('yassineb', 1, 0, 0, 'Sevilla', NULL),
('jesusn', 2, 2, 1, 'Sevilla', NULL),
('diegoac', 3, 1, 0, 'Sevilla', NULL),
('karims', 4, 3, 2, 'Sevilla', NULL),
('joanjo', 5, 2, 1, 'Sevilla', NULL),
('fernandor', 6, 4, 3, 'Sevilla', NULL),
('papeg', 7, 5, 4, 'Sevilla', NULL),
('lukedj', 8, 6, 2, 'Sevilla', NULL),
('erikl', 9, 1, 1, 'Sevilla', NULL),
('lucasd', 10, 2, 3, 'Sevilla', NULL),
('rafaelmir', 11, 3, 0, 'Sevilla', NULL),
('youssefen', 12, 4, 2, 'Sevilla', NULL);

INSERT INTO entrenador (user, tipoEntrenador, nombreEquipo, icon) VALUES
('julenl', 'Primer_entrenador', 'Sevilla', NULL),
('pablov', 'Segundo_entrenador', 'Sevilla', NULL);

-- Insert data into the juegan table
-- Matches for Athletic de Bilbao
INSERT INTO juegan (nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado) VALUES
('Athletic de Bilbao', 'Real Madrid', '2024-05-02 16:0:00', '1-2'),
('Athletic de Bilbao', 'Barcelona', '2024-05-07 18:00:00', '1-1'),
('Athletic de Bilbao', 'Atletico Madrid', '2024-05-10 20:00:00', '0-0'),
('Athletic de Bilbao', 'Sevilla', '2024-05-17 14:00:00', '0-0'),
('Real Madrid', 'Athletic de Bilbao', '2024-05-24 16:00:00', '0-0'),
('Barcelona', 'Athletic de Bilbao', '2024-05-31 18:00:00', '0-0'),
('Atletico Madrid', 'Athletic de Bilbao', '2024-06-07 20:00:00', '0-0');

-- Matches for Real Madrid
INSERT INTO juegan (nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado) VALUES
('Real Madrid', 'Athletic de Bilbao', '2024-05-01 16:00:00', '1-2'),
('Real Madrid', 'Barcelona', '2024-05-08 18:00:00', '2-1'),
('Real Madrid', 'Atletico Madrid', '2024-05-10 20:00:00', '3-0'),
('Real Madrid', 'Sevilla', '2024-05-17 14:00:00', '0-0'),
('Athletic de Bilbao', 'Real Madrid', '2024-05-24 16:00:00', '0-0'),
('Barcelona', 'Real Madrid', '2024-05-31 18:00:00', '0-0'),
('Atletico Madrid', 'Real Madrid', '2024-06-07 20:00:00', '0-0');

-- Matches for Barcelona
INSERT INTO juegan (nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado) VALUES
('Barcelona', 'Athletic de Bilbao', '2024-05-08 18:00:00', '1-1'),
('Barcelona', 'Real Madrid', '2024-05-15 20:00:00', '2-2'),
('Barcelona', 'Atletico Madrid', '2024-05-22 14:00:00', '0-0'),
('Barcelona', 'Sevilla', '2024-05-29 16:00:00', '0-0'),
('Athletic de Bilbao', 'Barcelona', '2024-06-05 18:00:00', '0-0'),
('Real Madrid', 'Barcelona', '2024-06-12 20:00:00', '0-0'),
('Atletico Madrid', 'Barcelona', '2024-06-19 14:00:00', '0-0');

-- Matches for Atletico Madrid
INSERT INTO juegan (nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado) VALUES
('Atletico Madrid', 'Athletic de Bilbao', '2024-05-05 14:00:00', '1-1'),
('Atletico Madrid', 'Real Madrid', '2024-05-12 16:00:00', '0-2'),
('Atletico Madrid', 'Barcelona', '2024-05-19 18:00:00', '0-0'),
('Atletico Madrid', 'Sevilla', '2024-05-26 20:00:00', '0-0'),
('Athletic de Bilbao', 'Atletico Madrid', '2024-06-02 14:00:00', '0-0'),
('Real Madrid', 'Atletico Madrid', '2024-06-09 16:00:00', '0-0'),
('Barcelona', 'Atletico Madrid', '2024-06-16 18:00:00', '0-0');

-- Matches for Sevilla
INSERT INTO juegan (nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, resultado) VALUES
('Sevilla', 'Athletic de Bilbao', '2024-05-03 20:00:00', '1-2'),
('Sevilla', 'Real Madrid', '2024-05-10 14:00:00', '1-1'),
('Sevilla', 'Barcelona', '2024-05-17 16:00:00', '0-0'),
('Sevilla', 'Atletico Madrid', '2024-05-24 18:00:00', '0-0'),
('Athletic de Bilbao', 'Sevilla', '2024-05-31 20:00:00', '0-0'),
('Real Madrid', 'Sevilla', '2024-06-07 14:00:00', '0-0'),
('Barcelona', 'Sevilla', '2024-06-14 16:00:00', '0-0');
