package model.usuarios;

import java.util.ArrayList;

import model.equipos.Equipo;

public class Entrenador extends Usuarios {

	private static final long serialVersionUID = 1L;
	private String nombreEquipo;
	private CargoEntrenador cargo;

	public Entrenador(String nombre, String user, String contrasenia, String nombreEquipo, CargoEntrenador cargo) {
		super(nombre, user, contrasenia);
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

//	//
//	public boolean comprobar(File fichEquipos, String nombreEquipo) {
//		ArrayList<Equipo> equiposLista = new ArrayList<>();
//
//		for (Equipo miEqui : equiposLista) {
//			if (miEqui.getNombreEquipo().equalsIgnoreCase(nombreEquipo)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
