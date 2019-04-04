package com.redlxians.quiz.view;
public class LoginController
{
	String userName;
	String password;

	public boolean validation(String userName,String password)
	{

		if(username=="admin"&&password=="admin")
		{
			ManagerView  m = new ManagerView();
			m.managerOptions();
		}
		else
		{
			System.out.println("false");
		}
	}
}