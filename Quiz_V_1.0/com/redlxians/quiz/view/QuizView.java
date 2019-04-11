package com.redlxians.quiz.view;

/**
*@author AJAY.E.S
*/
import java.util.*;
import com.redlxians.quiz.controller.*;
import com.redlxians.quiz.model.*;
import com.redlxians.quiz.view.*;
public class QuizView{
	
  public void display()
    {
      QuizSession quizSession=new QuizSession();
      ManagerController m = new ManagerController();
	    int score=0,answer,ready,quizType;
      String quizFile=null;
      ArrayList<Integer > useranswers = new ArrayList<Integer>();
	    Scanner in = new Scanner(System.in);
      do{
        System.out.println("\nSelect Quiz From Below\n");
        List<String> quizSessions = m.getQuizSession();
        for(int i = 0;i<quizSessions.size();i++){
          System.out.println((i+1)+"."+quizSessions.get(i));
          }
        int temp = in.nextInt();
        quizSession.getQuiz(temp);
        System.out.print("Press 1 to start the Quiz program: ");
        ready=in.nextInt();
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if(ready==1)
          {
          score=0;
          quizSession.creatingQuiz();
          for(int i=0;i<quizSession.quizes.size();i++)
             {
            System.out.print("\tQuestion"+(i+1)+"\n\t"+quizSession.quizes.get(i).getQuestion()+"\n\t\t1. "+quizSession.quizes.get(i).getOption()[0]+"\n\t\t2. "+quizSession.quizes.get(i).getOption()[1]+"\n\t\t3. "+quizSession.quizes.get(i).getOption()[2]+"\n\t\t4. "+quizSession.quizes.get(i).getOption()[3]+"\n5.Leave\n\nAnswer:");
            answer=in.nextInt();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
             if((quizSession.quizes.get(i).getAnswer()).equals(quizSession.quizes.get(i).getOption()[(answer-1)]))
               {
              score=score+5;
               }
           }
          System.out.print("Result = "+score+" out of "+(quizSession.quizes.size()*5)+"\n\nMenu\n1.Try again\n2.Main menu\n3.Stop\nSelect your choice:");
          ready=in.nextInt();
          if(ready==1)
             ready=0;
          else if(ready==2)
             { 
             LoginView lV=new LoginView();
             lV.display();
             }
          else
             ready=1;
          }
        else
         {
          ready=0;
         }
       }while(ready==0);
    }
}