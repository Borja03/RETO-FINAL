package model.usuarios;

import java.sql.Blob;

/**
 * Represents a coach (Entrenador) which is a type of Usuario.
 * A coach has attributes such as team name and coach position.
 */
public class Entrenador extends Usuarios {

    /**
     * The name of the team the coach is associated with.
     */
    private String nombreEquipo;
    
    /**
     * The position of the coach.
     */
    private CargoEntrenador cargo;

    /**
     * Constructs a new Entrenador with the specified details.
     *
     * @param nombre the name of the coach
     * @param user the username of the coach
     * @param contrasenia the password of the coach
     * @param nombreEquipo the name of the team
     * @param cargo the position of the coach
     */
    public Entrenador(String nombre, String user, String contrasenia, String nombreEquipo, CargoEntrenador cargo) {
        super(nombre, user, contrasenia);
        this.nombreEquipo = nombreEquipo;
        this.cargo = cargo;
    }

    /**
     * Constructs a new Entrenador with the specified details including profile picture.
     *
     * @param nombre the name of the coach
     * @param user the username of the coach
     * @param contrasenia the password of the coach
     * @param nombreEquipo the name of the team
     * @param cargo the position of the coach
     * @param picProfile the profile picture of the coach as a Blob
     */
    public Entrenador(String nombre, String user, String contrasenia, String nombreEquipo, CargoEntrenador cargo, Blob picProfile) {
        super(user, contrasenia, picProfile);
        this.nombreEquipo = nombreEquipo;
        this.cargo = cargo;
    }

    /**
     * Default constructor that initializes an Entrenador with default values.
     */
    public Entrenador() {
        super();
        this.nombreEquipo = "";
        this.cargo = null;
    }

    /**
     * Gets the name of the team the coach is associated with.
     *
     * @return the name of the team
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Sets the name of the team the coach is associated with.
     *
     * @param nombreEquipo the name of the team
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Gets the position of the coach.
     *
     * @return the position of the coach
     */
    public CargoEntrenador getCargo() {
        return cargo;
    }

    /**
     * Sets the position of the coach.
     *
     * @param cargo the position of the coach
     */
    public void setCargo(CargoEntrenador cargo) {
        this.cargo = cargo;
    }
}