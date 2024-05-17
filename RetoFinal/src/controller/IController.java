package controller;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.equipos.Equipo;
import model.partido.Juegan;
import model.usuarios.CargoEntrenador;
import model.usuarios.Jugador;
import model.usuarios.Usuarios;

public interface IController {
	public boolean checkUserExist(String user);

	public boolean logIn(String username, String pass, String userType);

	public boolean crearEquipo(String nombreEquipo, int titulos, String nombreEstadio, Blob logo);

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

	public String getMyTeam(String userName, String userType);

	public Usuarios getUsuario(String user);

	public ArrayList<Equipo> listarEquiposCP();

	boolean crearPartido(String equipoLocal, String equipoVisitante, java.sql.Timestamp fechaInicio);

	public Equipo getEquipo(String nombreEquipo);

	public String getPrimEntrenador(String eqName);

	public String getSegEntrenador(String eqName);

	public ArrayList<Integer> getUsedDorsal(String eqName);

	public ArrayList<Jugador> getJugadoresPorEquipo(String nombreEquipo);

	boolean cambiarPassword(String user, String newPassword, String userType);

	public boolean borrarEquipo(String nombreEquipo);

	public boolean modificarEquipo(String nombreEquipo, int titulos, String nombreEstadio, Blob logo);

	public String getUsuarioPassword(String userName, String userType);

	public boolean updateUsrIcon(String user, Blob userIcon, String userType);

	public void modificarPartido(Juegan juegan, LocalDateTime fecha);

	public ArrayList<Juegan> consultarPartidoEquipo(String equipoName);

	public ArrayList<Juegan> listaPartidos();

	boolean modificarJugadorConDorsal(String user, int dorsal);

	void updateAsistencias(String localTeam, String visitTeam, LocalDateTime matchTime);

	public void logOut();


}