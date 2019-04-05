package com.redlxians.quiz.controller;

import com.redlxians.quiz.view.ManagerView;
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
		else if(userName.equals("user")&&password.equals("user"))
		{
			QuizView  q = new QuizView();
			q.display();
			return false;
		}

		return true;
	}
	
}