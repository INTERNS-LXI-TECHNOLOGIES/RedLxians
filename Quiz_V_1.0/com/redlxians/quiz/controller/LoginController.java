package com.redlxians.quiz.controller;
<<<<<<< HEAD

import com.redlxians.quiz.view.*;
=======
>>>>>>> 26e78de889ef41d86552117d9b29661b98e10ee4
public class LoginController
{

	public boolean validation(String userName,String password)
	{

		if(userName.equals("admin")&&password.equals("admin"))
		{
			ManagerView  m = new ManagerView();
			m.managerOptions();
			return false;
		}
<<<<<<< HEAD
		else if(userName.equals("user")&&password.equals("user")){
			QuizView q = new QuizView();
=======
>>>>>>> 26e78de889ef41d86552117d9b29661b98e10ee4
			q.display();
			return false;
		}

		return true;
	}
	
}