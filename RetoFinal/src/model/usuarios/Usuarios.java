package model.usuarios;

import java.sql.Blob;

/**
 * Represents a user (Usuario) with attributes such as type, username, password, and profile picture.
 */
public class Usuarios {


    /**
     * The type of user.
     */
    protected String tipo;
    
    /**
     * The username of the user.
     */
    protected String user;
    
    /**
     * The password of the user.
     */
    protected String contrasenia;
    
    /**
     * The profile picture of the user.
     */
    protected Blob picProfile;

    /**
     * Default constructor that initializes a Usuario with default values.
     */
    public Usuarios() {
        this.tipo = "";
        this.user = "";
        this.contrasenia = "";
    }

    /**
     * Constructs a new Usuario with the specified type, username, and password.
     *
     * @param tipo the type of user
     * @param user the username of the user
     * @param contrasenia the password of the user
     */
    public Usuarios(String tipo, String user, String contrasenia) {
        this.tipo = tipo;
        this.user = user;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructs a new Usuario with the specified username, password, and profile picture.
     *
     * @param user the username of the user
     * @param contrasenia the password of the user
     * @param picProfile the profile picture of the user as a Blob
     */
    public Usuarios(String user, String contrasenia, Blob picProfile) {
        this.user = user;
        this.contrasenia = contrasenia;
        this.picProfile = picProfile;
    }

    /**
     * Gets the type of user.
     *
     * @return the type of user
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the type of user.
     *
     * @param tipo the type of user
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the username of the user.
     *
     * @param user the username of the user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Sets the password of the user.
     *
     * @param contrasenia the password of the user
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Gets the profile picture of the user.
     *
     * @return the profile picture of the user
     */
    public Blob getPicProfile() {
        return picProfile;
    }

    /**
     * Sets the profile picture of the user.
     *
     * @param picProfile the profile picture of the user
     */
    public void setPicProfile(Blob picProfile) {
        this.picProfile = picProfile;
    }
}
