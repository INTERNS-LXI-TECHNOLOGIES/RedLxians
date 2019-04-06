package com.redlxians.quiz.controller;
import com.redlxians.quiz.model.Quiz;
import java.util.ArrayList;
/**
*@author AJAY E.S
**/
import java.util.*;
import java.io.*;
<<<<<<< HEAD
=======
import com.redlxians.quiz.model.*;
public class QuizSession
{
	
   public ArrayList<Quiz> quizes = new ArrayList<Quiz>();
>>>>>>> 26e78de889ef41d86552117d9b29661b98e10ee4
   public void creatingQuiz(){
     File file=new File("Quiz.csv");
     try{
     FileReader fR=new FileReader(file);
<<<<<<< HEAD	 
=======
     BufferedReader bR=new BufferedReader(fR);
       
     String data;
     while((data = bR.readLine())!=null){
>>>>>>> 26e78de889ef41d86552117d9b29661b98e10ee4
   			String[] split = data.split(",");
   			Quiz quiz = new Quiz();
   			quiz.setQuestion(split[0]);
   			String[] options = new String[4];
   			for(int i=0;i<4;i++){
   				options[i] = split[i+1];
   			   }
   			quiz.setOption(options);
   			quiz.setAnswer(split[5]);
   			quizes.add(quiz);
   		}
<<<<<<< HEAD
      }catch(FileNotFoundException e){

      }
      catch(IOException e){
        
      }
=======
>>>>>>> 26e78de889ef41d86552117d9b29661b98e10ee4
	  }
	
}