package model.usuarios;

import java.sql.Blob;

public class Usuarios {

	private static final long serialVersionUID = 1L;
	protected String tipo;
	protected String user;
	protected String contrasenia;
	protected Blob picProfile;

	public Usuarios() {
		this.tipo = "";
		this.user = "";
		this.contrasenia = "";
	}




	public Usuarios(String nombre, String user, String contrasenia) {
		this.tipo = nombre;
		this.user = user;
		this.contrasenia = contrasenia;
	}
	

	public Usuarios(String user, String contrasenia,Blob picProfile) {
		this.user = user;
		this.contrasenia = contrasenia;
		this.picProfile = picProfile;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String nombre) {
		this.tipo = nombre;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	

	public Blob getPicProfile() {
		return picProfile;
	}


	public void setPicProfile(Blob picProfile) {
		this.picProfile = picProfile;
	}



	@Override
	public String toString() {
		return "Usuarios{" + "nombre='" + tipo + '\'' + '}';
	}
}
