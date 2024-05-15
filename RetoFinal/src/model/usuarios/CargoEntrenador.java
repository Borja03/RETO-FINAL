package model.usuarios;

/**
 * Represents the position of a coach (CargoEntrenador) with possible values: PRIMER_ENTRENADOR and SEGUNDO_ENTRENADOR.
 */
public enum CargoEntrenador {
    
    /**
     * The first coach (head coach).
     */
    PRIMER_ENTRENADOR("Primer_entrenador"),
    
    /**
     * The second coach (assistant coach).
     */
    SEGUNDO_ENTRENADOR("Segundo_entrenador");

    /**
     * The name of the coach position.
     */
    private final String nombre;

    /**
     * Constructs a new CargoEntrenador with the specified name.
     *
     * @param nombre the name of the coach position
     */
    CargoEntrenador(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the name of the coach position.
     *
     * @return the name of the coach position
     */
    public String getNombre() {
        return nombre;
    }
}
