package controller;

import java.util.ArrayList;

public interface IController {
	public boolean checkUserExist(String username, String pass, String userType);
  
	public boolean logOut();
  
	public void logIn();

	public void crearEquipo();

	public boolean crearEntrenador(String nombreEquipo, String user, String password, String tipoEntrenador);

	public void crearPartido();

	public boolean crearJugador(String user, String password, int dorsal, String nombreEquipo);

	public void borrarEntrenador();

	public void borrarJugador();

	public void modificarEntrenador();

	public void modificarJugador();

	public void modificarPartido();

	public void consultarEquipo();

	public void modificarDorsal();

	public void cambiarPassword();

	public void consultarPartido();
	
	public ArrayList<String> getEquipos();

	public String getMyTeam(String entName);
}
