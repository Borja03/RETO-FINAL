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

	public Usuarios(String nombre, String user, String contrase�a) {
		this.tipo = nombre;
		this.user = user;
		this.contrasena = contrase�a;
	}

	public Usuarios(String user, String contrase�a) {
		this.user = user;
		this.contrasena = contrase�a;
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

	public String getContrase�a() {
		return contrasena;
	}

	public void setContrase�a(String contrase�a) {
		this.contrasena = contrase�a;
	}

	@Override
	public String toString() {
		return "Usuarios{" + "nombre='" + tipo + '\'' + '}';
	}
}
