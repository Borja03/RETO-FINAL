package model.equipos;

import java.io.Serializable;

import java.sql.Blob;
import java.util.ArrayList;

import model.partido.Juegan;

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreEquipo;
	private String estadio;
	private int titulos;
	private Blob logo;
	private ArrayList<Juegan> listaPartido;

	public Equipo() {
		this.nombreEquipo = "";
		this.estadio = "";
		this.listaPartido = new ArrayList<>();
		this.titulos = 0;
	}

	public Equipo(String nombreEquipo, String estadio, int titulos) {
		this.nombreEquipo = nombreEquipo;
		this.estadio = estadio;
		this.titulos = titulos;
		this.listaPartido = new ArrayList<>();
	}

	public Equipo(String nombreEquipo, String estadio, int titulos,Blob logoLink) {
		this.nombreEquipo = nombreEquipo;
		this.estadio = estadio;
		this.titulos = titulos;
		this.logo = logoLink;
		this.listaPartido = new ArrayList<>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int getTitulos() {
		return titulos;
	}

	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}

	public ArrayList<Juegan> getListaPartido() {
		return listaPartido;
	}

	public void setListaPartido(ArrayList<Juegan> listaPartido) {
		this.listaPartido = listaPartido;
	}




	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public void getDatosEquipo() {
		System.out.println("-----Datos del equipo-----");
		System.out.println("Nombre del equipo : " + this.nombreEquipo);
		System.out.println("Estadio : " + this.estadio);
		System.out.println("Titulos : " + this.titulos);

	}
}