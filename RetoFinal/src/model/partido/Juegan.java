package model.partido;

import java.time.LocalDateTime;

public class Juegan {
	private String nombreEquipoLocal;
	private String nombreEquipoVisitante;
	private LocalDateTime fechaInicio;
	private String resultado;

	public Juegan(String nombreEquipoLocal, String nombreEquipoVisitante, LocalDateTime fechaInicio, String resultado) {
		this.nombreEquipoLocal = nombreEquipoLocal;
		this.nombreEquipoVisitante = nombreEquipoVisitante;
		this.fechaInicio = fechaInicio;
		this.resultado = resultado;
	}

	public String getNombreEquipoLocal() {
		return nombreEquipoLocal;
	}

	public void setNombreEquipoLocal(String nombreEquipoLocal) {
		this.nombreEquipoLocal = nombreEquipoLocal;
	}

	public String getNombreEquipoVisitante() {
		return nombreEquipoVisitante;
	}

	public void setNombreEquipoVisitante(String nombreEquipoVisitante) {
		this.nombreEquipoVisitante = nombreEquipoVisitante;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Juegan [nombreEquipoLocal=" + nombreEquipoLocal + ", nombreEquipoVisitante=" + nombreEquipoVisitante
				+ ", fechaInicio=" + fechaInicio + ", resultado=" + resultado + "]";
	}

}
