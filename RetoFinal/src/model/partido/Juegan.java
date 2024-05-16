package model.partido;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Represents a match (Juegan) between two teams with attributes such as local team name, visiting team name, start date, and result.
 */
public class Juegan {
    
    /**
     * The name of the home team.
     */
    private String nombreEquipoLocal;
    
    /**
     * The name of the visiting team.
     */
    private String nombreEquipoVisitante;
    
    /**
     * The start date and time of the match.
     */
    private LocalDateTime fechaInicio;
    
    /**
     * The result of the match.
     */
    private String resultado;

    private boolean assistUpdated=false;
    
    
    /**
     * Constructs a new Juegan instance with the specified local team name, visiting team name, start date, and result.
     *
     * @param nombreEquipoLocal the name of the home team
     * @param nombreEquipoVisitante the name of the visiting team
     * @param fechaInicio the start date and time of the match
     * @param resultado the result of the match
     */
    public Juegan(String nombreEquipoLocal, String nombreEquipoVisitante, LocalDateTime fechaInicio, String resultado) {
        this.nombreEquipoLocal = nombreEquipoLocal;
        this.nombreEquipoVisitante = nombreEquipoVisitante;
        this.fechaInicio = fechaInicio;
        this.resultado = resultado;
    }

    public Juegan(String nombreEquipoLocal, String nombreEquipoVisitante, LocalDateTime fechaInicio, String resultado,boolean assistUpdated) {
        this.nombreEquipoLocal = nombreEquipoLocal;
        this.nombreEquipoVisitante = nombreEquipoVisitante;
        this.fechaInicio = fechaInicio;
        this.resultado = resultado;
        this.assistUpdated=assistUpdated;
    }
    /**
     * Gets the name of the home team.
     *
     * @return the name of the home team
     */
    public String getNombreEquipoLocal() {
        return nombreEquipoLocal;
    }

    /**
     * Sets the name of the home team.
     *
     * @param nombreEquipoLocal the name of the home team
     */
    public void setNombreEquipoLocal(String nombreEquipoLocal) {
        this.nombreEquipoLocal = nombreEquipoLocal;
    }

    /**
     * Gets the name of the visiting team.
     *
     * @return the name of the visiting team
     */
    public String getNombreEquipoVisitante() {
        return nombreEquipoVisitante;
    }

    /**
     * Sets the name of the visiting team.
     *
     * @param nombreEquipoVisitante the name of the visiting team
     */
    public void setNombreEquipoVisitante(String nombreEquipoVisitante) {
        this.nombreEquipoVisitante = nombreEquipoVisitante;
    }

    /**
     * Gets the start date and time of the match.
     *
     * @return the start date and time of the match
     */
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the start date and time of the match.
     *
     * @param fechaInicio the start date and time of the match
     */
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Gets the result of the match.
     *
     * @return the result of the match
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Sets the result of the match.
     *
     * @param resultado the result of the match
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public boolean isAssistUpdated() {
		return assistUpdated;
	}

    public void setAssistUpdated(boolean assistUpdated) {
		this.assistUpdated = assistUpdated;
	}
    
    
}
