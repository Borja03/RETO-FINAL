package aplicacion;

import controller.Controller;
import aplicacion.Splash;


/**
 * The Main class is the entry point of the application.
 *
 * @author 1dami G1
 * @version 1.0
 * Date 2024-05-13 
 */

public class Main {

	/**
	 * The main method creates a Controller and a Splash instance, then makes the
	 * Splash visible.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		Splash splash = new Splash(controller);
		splash.setVisible(true);
	}
}