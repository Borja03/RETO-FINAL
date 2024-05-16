
use laliga;
DELIMITER //

CREATE PROCEDURE UpdateAsistenciasAfterMatch(
    IN p_localTeam VARCHAR(30),
    IN p_visitTeam VARCHAR(30),
    IN p_matchTime DATETIME
)
BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE localTeam VARCHAR(30);
    DECLARE visitTeam VARCHAR(30);
    DECLARE matchTime DATETIME;
    DECLARE isUpdated BOOLEAN;

    -- Declare cursor to fetch the specified match
    DECLARE cur CURSOR FOR 
        SELECT nombreEquipoLocal, nombreEquipoVisitante, fechaInicio, assistsUpdated
        FROM juegan
        WHERE nombreEquipoLocal = p_localTeam
        AND nombreEquipoVisitante = p_visitTeam
        AND fechaInicio = p_matchTime;

    -- Declare handler for cursor not found
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Open cursor
    OPEN cur;

    -- Fetch match
    FETCH cur INTO localTeam, visitTeam, matchTime, isUpdated;

    -- Check if assists_updated is false for the specified match
    IF NOT done THEN
        IF NOT isUpdated THEN
            -- Update assists
            UPDATE jugador 
            SET numeroAsistencias = numeroAsistencias + FLOOR(15 + (RAND() * (75-15+1)))
            WHERE nombreEquipo IN (localTeam, visitTeam);

            -- Update assists_updated
            UPDATE juegan
            SET assistsUpdated = TRUE
            WHERE nombreEquipoLocal = localTeam
            AND nombreEquipoVisitante = visitTeam
            AND fechaInicio = matchTime;
        END IF;
    END IF;

    -- Close cursor
    CLOSE cur;
END //

DELIMITER ;
