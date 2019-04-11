package com.redlxians.quiz.controller;
/**
*@author Sanjana P
*/
import com.redlxians.quiz.view.*;
import com.redlxians.quiz.model.*;
import java.util.*;
import java.io.*; 
import java.util.regex.Pattern;  
import java.util.regex.Matcher;
public class LoginController
{	
	ArrayList<User> users = new ArrayList<User>();
  	User admin = new User();
	public LoginController(){  
     try{
     int count=count(); 
     FileReader reader=new FileReader("db.properties");
     Properties p=new Properties();  
     p.load(reader);
   			
   			for(int i=0;i<(count/4);i++){
   				User user = new User();
   				user.setEmail(p.getProperty("email"+i));
   				user.setPassword(p.getProperty("password"+i));
   				users.add(user);
   				//System.out.println(users.get(i).getEmail());
   				//System.out.println(users.get(i).getPassword());
   			}
   				
   				admin.setEmail(p.getProperty("memailid"));
   				admin.setPassword(p.getProperty("mpassword"));
   				users.add(admin); 
   	     }
      catch(FileNotFoundException e){}
      catch(IOException e){}
	}

	public boolean validation(String emailid,String password)
	{

		try{
		int count=count();
		
		FileReader reader=new FileReader("db.properties");  
    	Properties p=new Properties();    
    	p.load(reader);   
		for(int i=0;i<users.size();i++){ 
			
			if(emailid.equals(users.get(i).getEmail())){
				if(password.equals(users.get(i).getPassword())){
					System.out.println("sucessfully logged in");
					QuizView q = new QuizView();
					q.display();

					return false;
				}
			}
            
			else if(emailid.equals(admin.getEmail()) && password.equals(admin.getPassword())){
				System.out.println("sucessfully logged in");
				ManagerView  m = new ManagerView();
				m.managerOptions();
				return false;
			}
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
					System.out.println("Registration is sucessfull");
	  				LoginView login=new LoginView();
	                login.display();   
	                return true;    
	            }  
	            else
	            {    
	                System.out.println("Entered email is illegal try again.");
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