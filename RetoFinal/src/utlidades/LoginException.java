package utlidades;

/**
 * Custom exception class for login-related errors.
 */
public class LoginException extends Exception {
	private static final long serialVersionUID = 1L;
	  /**
     * Constructs a new LoginException with the specified detail message.
     * @param mensaje The detail message (which is saved for later retrieval by the getMessage() method)
     */
	public LoginException(String mensaje) {
		super(mensaje);	
	}
	
}