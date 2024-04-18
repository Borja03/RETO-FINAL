
package controller;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.equipos.Equipo;
import model.usuarios.CargoEntrenador;
import model.usuarios.Tipo;
import model.usuarios.Usuarios;

import model.equipos.Equipo;

public interface IController {
	public boolean checkUserExist(String user);

	public void logOut();

	public boolean logIn(String username, String pass, String userType);

	public void crearEquipo(String nombreEquipo, int titulos, String nombreEstadio);

	public boolean crearEntrenador(String nombreEquipo, String user, String password, CargoEntrenador tipoEntrenador);

	public boolean crearJugador(String user, String password, int dorsal, int numeroGoles, int numeroAsistencias,
			String nombreEquipo);

	public boolean borrarEntrenador(String user);

	public boolean borrarJugador(String userName);

	public boolean modificarEntrenador(String user, String password, CargoEntrenador tipoEntrenador);

	public boolean modificarJugador(String user, String password, int dorsal, int numGoles, int numAsist);

	public void consultarEquipo();

	public void modificarDorsal();

	public void consultarPartido();

	public ArrayList<String> getEquipos();

	public String getMyTeam(String entName);

	public Usuarios getUsuario(String user);

	public ArrayList<Equipo> listarEquiposCP();

	boolean crearPartido(String equipoLocal, String equipoVisitante, java.sql.Timestamp fechaInicio);

	boolean cambiarPassword(String user, String newPassword, String userType);

	boolean modificarPartido(String nombrePartido, String nuevoResultado);

}
