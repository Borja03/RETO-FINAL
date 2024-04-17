package model.usuarios;

public enum CargoEntrenador {
	PRIMER_ENTRENADOR("Primer_entrenador"), SEGUNDO_ENTRENADOR("Segundo_entrenador");

	private final String nombre;

	CargoEntrenador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
