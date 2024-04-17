package model.usuarios;


public class Usuarios {

	private static final long serialVersionUID = 1L;
	protected String tipo;
	protected String user;
	protected String contrasena;

	public Usuarios() {
		this.tipo = "";
		this.user = "";
		this.contrasena = "";
	}

	public Usuarios(String nombre, String user, String contrasenia) {
		this.tipo = nombre;
		this.user = user;
		this.contrasena = contrasenia;
	}

	public Usuarios(String user, String contrasenia) {
		this.user = user;
		this.contrasena = contrasenia;
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
		return contrasena;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasena = contrasenia;
	}

	@Override
	public String toString() {
		return "Usuarios{" + "nombre='" + tipo + '\'' + '}';
	}
}
