package com.redlxians.quiz.view;

import java.io.*;
import java.util.*;
import com.redlxians.quiz.controller.ManagerController;
import com.redlxians.quiz.model.Quiz;
import com.redlxians.quiz.view.LoginView;
/**
*@author Mohammed Anish
*/
public class ManagerView{
	static Scanner scan = new Scanner(System.in);
	ManagerController manager = new ManagerController();
	public void managerOptions(){
		int temp = 0;
		do{
			int option;
			System.out.println("1.Create\n2.Read\n3.Update\n4.Delete\n5.Add");
			option = scan.nextInt();
			switch(option){
				case 1:
				fileCreationView();
				break;
				case 2:
				quizSelectionView();
				readView();
				break;
				case 3:
				
				int opt = 0;
				do{
					quizSelectionView();
					readView();
					System.out.println("\nSelect from above");
					int select = scan.nextInt();
					System.out.println("\nSelet which Part to edit\n 1.Question\n 2.Options\n 3.Answer");
					int section = scan.nextInt();
					manager.update(select,section);
					System.out.println("1.Update More\nPress any key to exit");
					opt = scan.nextInt();
				}while(opt == 1);
				break;
				case 4:
				deleteMenu();
				break;
				case 5:
				int opt2 = 0;
				do{
					quizSelectionView();
					manager.add();
					System.out.println("1.Add More\nPress any key to exit");
					opt2 = scan.nextInt();
				}while(opt2 == 1);
				default:
				LoginView l = new LoginView();
				l.display();
				break;

			}
			System.out.println("1.Admin menu\n2.Logout");
			temp = scan.nextInt();
			manager.getQuizes().clear();
			if(temp==2){
				LoginView l = new LoginView();
				l.display();
			}
		}
		while(temp==1);
	}
	public void readView(){
		ArrayList<Quiz> quizes = manager.read();
		for(int i=0;i<quizes.size();i++){
			System.out.println("("+(i+1)+")"+quizes.get(i).getQuestion());
			for(int j=0;j<4;j++){
				System.out.println((j+1)+"."+quizes.get(i).getOption()[j]);
			}
			System.out.println("Answer : "+quizes.get(i).getAnswer()+"\n");
		}
	}
	public void quizSelectionView(){
		System.out.println("Select Quiz From Below\n");
		List<String> quizSessions = manager.getQuizSession();
		for(int i = 0;i<quizSessions.size();i++){
			System.out.println((i+1)+"."+quizSessions.get(i));
		}
		int temp = scan.nextInt();
		manager.quizSelection(temp);
	}
	public void fileCreationView(){
		System.out.println("Enter Quiz Name");
		String name = scan.next();
		manager.create(name);
		System.out.println("File Creation Sucsess");
	}
	public void deleteMenu(){
		System.out.println("1.Delete QuizSession\n2.Delete Quiz");
		int temp = scan.nextInt();
		int opt=0;
		if(temp==2){
			
			do{
				quizSelectionView();
				readView();
				System.out.println("\nSelect from above");
				int select = scan.nextInt();
				manager.delete(select);
				System.out.println("1.Delete More\nPress any key to exit");
				opt = scan.nextInt();
				manager.getQuizes().clear();
			}while(opt == 1);
			System.out.println("Quiz deletion Sucsess");
		}
		else if(temp==1){
			System.out.println("Select Quiz From Below\n");
			List<String> quizSessions = manager.getQuizSession();
			for(int i = 0;i<quizSessions.size();i++){
				System.out.println((i+1)+"."+quizSessions.get(i));
			}
			int a = scan.nextInt();
			manager.deleteQuizSession(a);
			System.out.println("Quiz Session Deleetion Sucsess");
		}
	}
}