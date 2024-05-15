package model.usuarios;

import java.sql.Blob;

/**
 * Represents a player (Jugador) which is a type of Usuario.
 * A player has attributes such as team name, jersey number, goals, and assists.
 */
public class Jugador extends Usuarios {
    /**
     * The name of the team the player belongs to.
     */
    private String nombreEquipo;
    
    /**
     * The jersey number of the player.
     */
    private int dorsal;
    
    /**
     * The number of goals scored by the player.
     */
    private int goles;
    
    /**
     * The number of assists made by the player.
     */
    private int asistencias;

    /**
     * Constructs a new Jugador with the specified details.
     *
     * @param tipo the type of user
     * @param user the username of the player
     * @param contrasenia the password of the player
     * @param nombreEquipo the name of the team
     * @param dorsal the jersey number of the player
     * @param goles the number of goals scored by the player
     * @param asistencias the number of assists made by the player
     */
    public Jugador(String tipo, String user, String contrasenia, String nombreEquipo, int dorsal, int goles, int asistencias) {
        super(tipo, user, contrasenia);
        this.nombreEquipo = nombreEquipo;
        this.dorsal = dorsal;
        this.goles = goles;
        this.asistencias = asistencias;
    }

    /**
     * Default constructor that initializes a Jugador with default values.
     */
    public Jugador() {
        super();
        this.nombreEquipo = "";
        this.dorsal = 0;
        this.goles = 0;
        this.asistencias = 0;
    }

    /**
     * Constructs a new Jugador with the specified details including profile picture.
     *
     * @param user the username of the player
     * @param contrasenia the password of the player
     * @param nombreEquipo the name of the team
     * @param dorsal the jersey number of the player
     * @param goles the number of goals scored by the player
     * @param asistencias the number of assists made by the player
     * @param picProfile the profile picture of the player as a Blob
     */
    public Jugador(String user, String contrasenia, String nombreEquipo, int dorsal, int goles, int asistencias, Blob picProfile) {
        super(user, contrasenia, picProfile);
        this.nombreEquipo = nombreEquipo;
        this.dorsal = dorsal;
        this.goles = goles;
        this.asistencias = asistencias;
    }

    /**
     * Gets the name of the team the player belongs to.
     *
     * @return the name of the team
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Sets the name of the team the player belongs to.
     *
     * @param nombreEquipo the name of the team
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Gets the jersey number of the player.
     *
     * @return the jersey number
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * Sets the jersey number of the player.
     *
     * @param dorsal the jersey number
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Gets the number of goals scored by the player.
     *
     * @return the number of goals
     */
    public int getGoles() {
        return goles;
    }

    /**
     * Sets the number of goals scored by the player.
     *
     * @param goles the number of goals
     */
    public void setGoles(int goles) {
        this.goles = goles;
    }

    /**
     * Gets the number of assists made by the player.
     *
     * @return the number of assists
     */
    public int getAsistencias() {
        return asistencias;
    }

    /**
     * Sets the number of assists made by the player.
     *
     * @param asistencias the number of assists
     */
    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }
}
