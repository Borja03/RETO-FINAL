use laLiga;

CREATE ROLE admin_role;
CREATE ROLE entrenador_role;
CREATE ROLE jugador_role;

GRANT ALL PRIVILEGES ON laLiga.equipo TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.entrenador TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.partidos TO admin_role;
GRANT ALL PRIVILEGES ON laLiga.juegan TO admin_role;
GRANT ALL PRIVILEGES ON laliga.usuario TO admin_role;

GRANT SELECT ON laLiga.equipo TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.juegan TO entrenador_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON laLiga.jugador TO entrenador_role;
GRANT SELECT, UPDATE ON laLiga.entrenador TO entrenador_role;
GRANT SELECT, UPDATE ,INSERT ON laLiga.usuario TO entrenador_role;

GRANT SELECT, UPDATE ON laLiga.jugador TO jugador_role;
GRANT SELECT, UPDATE ON laliga.usuario TO jugador_role;
GRANT SELECT ON laLiga.equipo TO jugador_role;
GRANT SELECT ON laLiga.juegan TO jugador_role;
GRANT SELECT ON laLiga.entrenador TO jugador_role;
CREATE USER 'admin'@'localhost'  IDENTIFIED by 'admin' default role 'admin_role';
CREATE USER 'entrenador'@'localhost'  IDENTIFIED by 'entrenador' default role 'entrenador_role';
CREATE USER 'jugador'@'localhost'  IDENTIFIED by 'jugador' default role 'jugador_role';

GRANT EXECUTE ON PROCEDURE laliga.UpdateAsistenciasAfterMatch TO 'jugador'@'localhost';
