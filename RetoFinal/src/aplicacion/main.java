package aplicacion;

import controller.Controller;
import view.Login;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		Login login = new Login(controller);
		login.setVisible(true);
	}

}