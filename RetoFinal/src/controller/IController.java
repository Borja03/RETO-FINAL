package controller;

import java.util.ArrayList;

public interface IController {
	public boolean checkUserExist(String username, String pass, String userType);
	public boolean logOut();

}
