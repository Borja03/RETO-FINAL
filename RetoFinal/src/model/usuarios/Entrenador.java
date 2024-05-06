package model.usuarios;

import java.sql.Blob;
import java.util.ArrayList;


import model.equipos.Equipo;
import model.usuarios.CargoEntrenador;

public class Entrenador extends model.usuarios.Usuarios {

	private static final long serialVersionUID = 1L;
	private String nombreEquipo;
	private model.usuarios.CargoEntrenador cargo;

	public Entrenador(String nombre, String user, String contrasenia, String nombreEquipo, model.usuarios.CargoEntrenador cargo) {
		super(nombre, user, contrasenia);
		this.nombreEquipo = nombreEquipo;
		this.cargo = cargo;
	}
	public Entrenador(String nombre, String user, String contrasenia, String nombreEquipo, CargoEntrenador cargo, Blob picProfile) {
		super(user, contrasenia,picProfile);
		this.nombreEquipo = nombreEquipo;
		this.cargo = cargo;
	}

	public Entrenador() {
		super();
		this.nombreEquipo = "";
		this.cargo = null;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public CargoEntrenador getCargo() {
		return cargo;
	}

	public void setCargo(CargoEntrenador cargo) {
		this.cargo = cargo;
	}
}
