package controller;

import java.util.ArrayList;

import model.equipos.Equipo;

public interface IController {
	public boolean checkUserExist(String username, String pass, String userType);
  
	public boolean logOut();
  
	public void logIn();

	public void crearEquipo();

	public void crearEntrenador();

	public void crearPartido();

	public void crearJugador();

	public void borrarEntrenador();

	public void borrarJugador();

	public void modificarEntrenador();

	public void modificarJugador();

	public void modificarPartido();

	public void consultarEquipo();

	public void modificarDorsal();

	public void cambiarPassword();

	public void consultarPartido();
	
	public ArrayList<Equipo> listarEquiposCP ();
}
