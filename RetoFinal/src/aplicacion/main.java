
package aplicacion;

import controller.Controller;
import aplicacion.Splash;

public class main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Splash splash = new Splash(controller);
		splash.setVisible(true);	

	}

}

