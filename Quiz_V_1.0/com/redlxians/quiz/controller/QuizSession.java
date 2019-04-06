package com.redlxians.quiz.controller;
import com.redlxians.quiz.model.Quiz;
import java.util.ArrayList;
/**
*@author AJAY E.S
**/
import java.util.*;
import java.io.*;
import com.redlxians.quiz.model.*;
public class QuizSession
{
	
   public ArrayList<Quiz> quizes = new ArrayList<Quiz>();
   public void creatingQuiz(String quizFile){
     File file=new File(quizFile);
     try{
     FileReader fR=new FileReader(file);
     BufferedReader bR=new BufferedReader(fR);
       
     String data;
     while((data = bR.readLine())!=null){
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
      }catch(FileNotFoundException e){

      }
      catch(IOException e){
        
      }
      
	  }
	
}