package com.redlxians.quiz.controller;
/**
*@author Sanjana P
*/
import com.redlxians.quiz.view.*;
import java.util.*;
import java.io.*; 
public class LoginController
{

	public boolean validation(String userName,String password)throws Exception
	{
		FileReader reader=new FileReader("db.properties");  
      
    	Properties p=new Properties();  
    	p.load(reader);  
      
   		System.out.println(p.getProperty("MuserName"));  
	
		if(userName.equals(p.getProperty("MuserName"))&&password.equals(p.getProperty("Mpassword")))
		{
			ManagerView  m = new ManagerView();
			m.managerOptions();
			return false;
		}
		else if(userName.equals(p.getProperty("userName"))&&password.equals(p.getProperty("password"))){
			QuizView q = new QuizView();
			q.display();
			return false;
		}

		return true;
	}
	
}