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
		System.out.println("Enter your choice:");
		System.out.println("1.Login\n2.Register\n3.Exit");
		int a = in.nextInt();
		if(a==1){
			login();
		}
		else if(a==2){
			register();
		}
		else if(a==3){
			exit();
		}
	}

	public void login()
	{

		boolean validate = false;
		int input = 0;
		do{
			System.out.println("Enter the email id of user: ");
			emailid=in.next();
			System.out.println("Enter the password: ");
			password=in.next();

			validate = loginController.validation(emailid,password);

			if(validate){
				System.out.println("Invalid User\nGo to previous menu press 1");
				input = in.nextInt();
				display();
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

	public void exit(){
		System.out.println("Thank you...");
	}

}
