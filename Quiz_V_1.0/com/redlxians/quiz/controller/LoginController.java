package com.redlxians.quiz.controller;
/**
*@author Sanjana P
*/
import com.redlxians.quiz.view.*;
import java.util.*;
import java.io.*; 
import java.util.regex.Pattern;  
import java.util.regex.Matcher;
public class LoginController
{

	public boolean validation(String emailid,String password)
	{
		try{
		int count=count();
		System.out.println(count);
		FileReader reader=new FileReader("db.properties");  
      
    	Properties p=new Properties();  
    	p.load(reader);   
		
		for(int i=0;i<(count/4);i++){ 
			if(emailid.equals(p.getProperty("email"+i))){
				if(password.equals(p.getProperty("password"+i))){
					QuizView q = new QuizView();
					q.display();
					return false;
				}
			}
			else{
				return true;
			}
		}
		if(emailid.equals(p.getProperty("Manager mailid"))&&password.equals(p.getProperty("Manager password")))
		{
			ManagerView  m = new ManagerView();
			m.managerOptions();
			return false;
		}
		else{
			return false;
		}

		}
		catch(IOException e){

		}
		return true;
		
	}
	public boolean registerValidation(String email,String pass){
		Scanner sc=new Scanner(System.in); 
		try{
	        
				int count=count();
	            Pattern pattern = Pattern.compile("\\w+@\\w+\\.[a-z]{2,3}");    
	            Matcher matcher = pattern.matcher(email);     
	            if (matcher.find()==true) 
	            {   

	            	Properties p=new Properties();  
					p.setProperty("email"+(count/4),matcher.group());
					p.setProperty("password"+(count/4),pass);  
	  				
					p.store(new FileWriter("db.properties",true),"");    
	                return true;    
	            }  
	            else
	            {    
	                System.out.println("Entered email pattern is illegal try again.");
	                LoginView login=new LoginView();
	                login.register();
	                return true;
	            }
	        }
	    catch(IOException e){

	    }

	    return false;
	   
	}
	public int count()
	{
		int count=0;
	try{
		FileReader reader=new FileReader(new File("db.properties"));  
         
  	 BufferedReader bR=new BufferedReader(reader);
  	 String data;   
	
		while(bR.readLine()!= null)
		{ 
			count++;
        }
		}
		catch(IOException e){

		}	
		return count;
	}
}