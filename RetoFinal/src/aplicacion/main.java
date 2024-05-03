
package aplicacion;

import controller.Controller;
import view.Login;
import aplicacion.Splash;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		Splash splash = new Splash(controller);
		splash.setVisible(true);
		// Login login = new Login(controller);
		// login.setVisible(true);
	}

}

