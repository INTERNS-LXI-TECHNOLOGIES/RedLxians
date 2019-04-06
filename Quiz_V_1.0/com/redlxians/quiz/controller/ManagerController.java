package com.redlxians.quiz.controller;

import java.io.*;

import java.util.*;
import com.redlxians.quiz.model.Quiz;
import com.redlxians.quiz.view.LoginView;
import com.redlxians.quiz.view.ManagerView;

/**
*@author Mohammed Anish
*/
public class ManagerController{

	File f = new File("Quiz.csv");
	ArrayList<Quiz> quizes = new ArrayList<Quiz>();
	static Scanner scan = new Scanner(System.in);

	public void create(){
		try{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		}
		catch(FileNotFoundException e){

		}

		System.out.println("create");
	}
	public ArrayList<Quiz> read(){
		
		String data;
		try{
			FileReader fR = new FileReader(f);
			BufferedReader bR = new BufferedReader(fR);
			while((data = bR.readLine())!= null){
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
     	return quizes;

	}
	public void update(){
		int opt = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do{
			System.out.println("\nSelect from above");
			int select = scan.nextInt();
			System.out.println("\nSelet which Part to edit\n 1.Question\n 2.Options\n 3.Answer");
			int temp = scan.nextInt();
			switch(temp){
				case 1:
				System.out.println("Enter new Question");
				try{
					quizes.get(select-1).setQuestion(reader.readLine());
				}
				catch(IOException e){

				}
				break;
				case 2:
				System.out.println("Enter new Options");
				String[] options = new String[4];
				for(int i=0;i<4;i++){
					System.out.print((i+1)+".");
					options[i] = scan.next();
					System.out.print("\n");
				}
				quizes.get(select-1).setOption(options);
				case 3:
				System.out.println("Enter new Answer");
				quizes.get(select-1).setAnswer(scan.next());
			}
			write();
			System.out.println("1.Update More\n2.Main Menu\n3.Admin menu\nPress any key to exit");
			opt = scan.nextInt();
			if(opt==2){
				LoginView l = new LoginView();
				l.display();
			}
			else if(opt==3){
				new ManagerView().managerOptions();
			}
		}while(opt == 1);
		
	}
	public void delete(){
		int opt = 0;
		do{
			System.out.println("\nSelect from above");
			int select = scan.nextInt();
			quizes.remove(select-1);
			write();
			System.out.println("1.Delete More\n2.Main Menu\n3.Admin menu\nPress any key to exit");
			opt = scan.nextInt();
			if(opt==2){
				LoginView l = new LoginView();
				l.display();
			}
			else if(opt==3){
				new ManagerView().managerOptions();
			}
		}while(opt == 1);

	}
	public void add(){
		read();
		int opt;
		do{
			String[] options = new String[4];
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Quiz quiz = new Quiz();
			System.out.println("Enter Question");
			try{
				quiz.setQuestion(reader.readLine());
			}
			catch(IOException e){

			}
			System.out.println("Enter Options");
			for(int i=0;i<4;i++){
					System.out.print((i+1)+".");
					options[i] = scan.next();
					System.out.print("\n");
				}
			quiz.setOption(options);
			System.out.println("Enter Answer");
			quiz.setAnswer(scan.next());
			quizes.add(quiz);
			write();
			System.out.println("1.Add More\n2.Main Menu\n3.Admin menu\nPress any key to exit");
			opt = scan.nextInt();
			if(opt==2){
				LoginView l = new LoginView();
				l.display();
			}
			else if(opt==3){
				new ManagerView().managerOptions();
			}
		}while(opt == 1);

	}
	public void write(){
		FileWriter fw;
		BufferedWriter bw;
		try{
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			for(int i=0;i<quizes.size();i++){
			bw.write(quizes.get(i).toString());
			}
		bw.close();
		}
		catch(IOException e){

		}
	}
} 