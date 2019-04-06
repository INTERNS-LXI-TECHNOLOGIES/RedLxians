package com.redlxians.quiz.view;
/**
*@author Sanjana P
*/
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
		int input = 0;
		do{
			System.out.println("Enter the username: ");
			userName=in.next();
			System.out.println("Enter the password: ");
			password=in.next();
			validate = loginController.validation(userName,password);
			if(validate){
				System.out.println("Invalid User\n Press 1 to Try Again");
				input = in.nextInt();
			}
		}while(input==1);

	}

}
