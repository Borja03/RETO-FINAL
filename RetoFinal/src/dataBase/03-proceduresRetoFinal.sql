use laliga;
DELIMITER //
CREATE PROCEDURE InsertarEquipo(
    IN nombreEquipo VARCHAR(30),
    IN titulos INT UNSIGNED,
    IN nombreEstadio VARCHAR(30),
    IN logo BLOB
)
BEGIN
    INSERT INTO laliga.equipo(nombreEquipo, titulos, nombreEstadio, logo) 
    VALUES (nombreEquipo, titulos, nombreEstadio, logo);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE ActualizarEquipo(
    IN nombreEquipo VARCHAR(30),
    IN titulos INT UNSIGNED,
    IN nombreEstadio VARCHAR(30),
    IN logo BLOB
)
BEGIN
    UPDATE laliga.equipo
    SET titulos = titulos,
        nombreEstadio = nombreEstadio,
        logo = logo
    WHERE nombreEquipo = nombreEquipo;
END //
DELIMITER ;