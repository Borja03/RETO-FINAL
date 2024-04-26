<<<<<<< HEAD
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
=======
package aplicacion;

import controller.Controller;
import view.Login;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		Splash splash = new Splash(controller);
		splash.setVisible(true);
		//Login login = new Login(controller);
		//login.setVisible(true);
	}

}
>>>>>>> c027c9284a54636c2c83b8c9c4e557de6dbb2f7d
