package model.equipos;

import java.sql.Blob;
import java.util.ArrayList;

import model.partido.Juegan;

/**
 * Represents a team (Equipo) with attributes such as team name, stadium, titles, logo, and a list of matches.
 */
public class Equipo {

 
    /**
     * The name of the team.
     */
    private String nombreEquipo;
    
    /**
     * The name of the stadium where the team plays.
     */
    private String estadio;
    
    /**
     * The number of titles the team has won.
     */
    private int titulos;
    
    /**
     * The logo of the team as a Blob.
     */
    private Blob logo;
    
    /**
     * A list of matches the team has played.
     */
    private ArrayList<Juegan> listaPartido;

    /**
     * Default constructor that initializes an Equipo with default values.
     */
    public Equipo() {
        this.nombreEquipo = "";
        this.estadio = "";
        this.listaPartido = new ArrayList<>();
        this.titulos = 0;
    }

    /**
     * Constructs a new Equipo with the specified team name, stadium, and number of titles.
     *
     * @param nombreEquipo the name of the team
     * @param estadio the name of the stadium
     * @param titulos the number of titles the team has won
     */
    public Equipo(String nombreEquipo, String estadio, int titulos) {
        this.nombreEquipo = nombreEquipo;
        this.estadio = estadio;
        this.titulos = titulos;
        this.listaPartido = new ArrayList<>();
    }

    /**
     * Constructs a new Equipo with the specified team name, stadium, number of titles, and logo.
     *
     * @param nombreEquipo the name of the team
     * @param estadio the name of the stadium
     * @param titulos the number of titles the team has won
     * @param logo the logo of the team as a Blob
     */
    public Equipo(String nombreEquipo, String estadio, int titulos, Blob logo) {
        this.nombreEquipo = nombreEquipo;
        this.estadio = estadio;
        this.titulos = titulos;
        this.logo = logo;
        this.listaPartido = new ArrayList<>();
    }

    /**
     * Gets the name of the team.
     *
     * @return the name of the team
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Sets the name of the team.
     *
     * @param nombreEquipo the name of the team
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Gets the name of the stadium where the team plays.
     *
     * @return the name of the stadium
     */
    public String getEstadio() {
        return estadio;
    }

    /**
     * Sets the name of the stadium where the team plays.
     *
     * @param estadio the name of the stadium
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     * Gets the number of titles the team has won.
     *
     * @return the number of titles
     */
    public int getTitulos() {
        return titulos;
    }

    /**
     * Sets the number of titles the team has won.
     *
     * @param titulos the number of titles
     */
    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    /**
     * Gets the list of matches the team has played.
     *
     * @return the list of matches
     */
    public ArrayList<Juegan> getListaPartido() {
        return listaPartido;
    }

    /**
     * Sets the list of matches the team has played.
     *
     * @param listaPartido the list of matches
     */
    public void setListaPartido(ArrayList<Juegan> listaPartido) {
        this.listaPartido = listaPartido;
    }

    /**
     * Gets the logo of the team.
     *
     * @return the logo of the team
     */
    public Blob getLogo() {
        return logo;
    }

    /**
     * Sets the logo of the team.
     *
     * @param logo the logo of the team
     */
    public void setLogo(Blob logo) {
        this.logo = logo;
    }

  
}
