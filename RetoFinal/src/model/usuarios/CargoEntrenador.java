package model.usuarios;

public enum CargoEntrenador {
	PRIMER_ENTRENADOR("Primer entrenador"), SEGUNDO_ENTRENADOR("Segundo entrenador");

	private final String nombre;

	CargoEntrenador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
