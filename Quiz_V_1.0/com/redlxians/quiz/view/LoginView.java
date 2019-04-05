package com.redlxians.quiz.view;
import java.util.*;
import com.redlxians.quiz.controller.LoginController;
public class LoginView
{
	String userName;
	String password;
	static Scanner in=new Scanner(System.in);
	LoginController loginController = new LoginController();
	public void display()
	{

		boolean validate;
		do{
			System.out.println("Enter the username: ");
			userName=in.next();
			System.out.println("Enter the password: ");
			password=in.next();
			validate = loginController.validation(userName,password);
		}while(validate);

	}

}
