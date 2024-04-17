<<<<<<< HEAD
use laLiga;



GRANT ALL PRIVILEGES ON laLiga.equipo TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.entrenador TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.juegan TO admin_role;

GRANT SELECT ON laLiga.equipo TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.juegan TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.jugador TO entrenador_role;
GRANT SELECT, UPDATE ON laLiga.entrenador TO entrenador_role;

GRANT SELECT, UPDATE ON laLiga.jugador TO jugador_role;
GRANT SELECT ON laLiga.equipo TO jugador_role;
GRANT SELECT ON laLiga.juegan TO jugador_role;
GRANT SELECT ON laLiga.entrenador TO jugador_role;

CREATE USER 'admin'@'localhost'  IDENTIFIED by 'admin' default role 'admin_role';
CREATE USER 'entrenador'@'localhost'  IDENTIFIED by 'entrenador' default role 'entrenador_role';
=======
use laLiga;

CREATE ROLE admin_role;
CREATE ROLE entrenador_role;
CREATE ROLE jugador_role;
CREATE ROLE logIn;

GRANT ALL PRIVILEGES ON laLiga.equipo TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.entrenador TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.partidos TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.juegan TO admin_role;

GRANT SELECT ON laLiga.equipo TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.partidos TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.juegan TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.jugador TO entrenador_role;
GRANT SELECT, UPDATE ON laLiga.entrenador TO entrenador_role;

GRANT SELECT, UPDATE ON laLiga.jugador TO jugador_role;
GRANT SELECT ON laLiga.equipo TO jugador_role;
GRANT SELECT ON laLiga.partidos TO jugador_role;
GRANT SELECT ON laLiga.juegan TO jugador_role;
GRANT SELECT ON laLiga.entrenador TO jugador_role;

CREATE USER 'admin'@'localhost'  IDENTIFIED by 'admin' default role 'admin_role';
CREATE USER 'entrenador'@'localhost'  IDENTIFIED by 'entrenador' default role 'entrenador_role';
>>>>>>> 64ece0c9f44ad5f2b9282575d684f969240645f3
CREATE USER 'jugador'@'localhost'  IDENTIFIED by 'jugador' default role 'jugador_role';