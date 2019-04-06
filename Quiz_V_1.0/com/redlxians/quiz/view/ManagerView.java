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

		int option;
		System.out.println("1.Create\n2.Read\n3.Update\n4.Delete\n5.Add");
		option = scan.nextInt();
		switch(option){
			case 1:
			manager.create();
			break;
			case 2:
			readView();
			System.out.println("Press 1 to Main menu\nPress any key to Exit");
			int opt = scan.nextInt();
			if(opt==1){
				LoginView l = new LoginView();
				l.display();
			}
			break;
			case 3:
			readView();
			manager.update();
			break;
			case 4:
			readView();
			manager.delete();
			break;
			case 5:
			manager.add();
			default:
			LoginView l = new LoginView();
			l.display();
			break; 
		}

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
}