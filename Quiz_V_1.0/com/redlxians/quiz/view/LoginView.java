package com.redlxians.quiz.view;
/**
*@author Sanjana P
*/
import java.util.*;

import com.redlxians.quiz.controller.LoginController;
public class LoginView
{
	String emailid;
	String password;
	static Scanner in=new Scanner(System.in);
	LoginController loginController = new LoginController();
	public void display(){
		System.out.println("1.Login\n2.Register");
		int a = in.nextInt();
		if(a==1){
			login();
		}
		else if(a==2){
			register();
		}
	}
	public void login()
	{

		boolean validate;
		int input = 0;
		do{
			System.out.println("Enter the email id of user: ");
			emailid=in.next();
			System.out.println("Enter the password: ");
			password=in.next();
			validate = loginController.validation(emailid,password);
			if(validate){
				System.out.println("Invalid User\n Press 1 to Try Again");
				input = in.nextInt();
			}
		}while(input==1);

	}
	public void register(){
		System.out.println("Enter Email id");
		String email = in.next();
		System.out.println("Enter Password");
		String pass = in.next();
		loginController.registerValidation(email,pass);
	}

}
