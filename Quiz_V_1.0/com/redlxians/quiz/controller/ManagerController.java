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


	File f;
	private ArrayList<Quiz> quizes = new ArrayList<Quiz>();
	static Scanner scan = new Scanner(System.in);

	public ArrayList<Quiz> getQuizes(){
		return quizes;
	}
	public void quizSelection(int selectedQuiz){
		Properties p = new Properties();
		try{
			p.load(new FileReader("QuizSession.properties"));
		}
		catch(Exception e){

		}
		f = new File(p.getProperty("filename"+selectedQuiz));
	}
	public void create(String fileName){
		int count = 0;
		File f = new File("QuizSession.properties");
		try{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine()!= null){
				count++;
			}
		}catch(IOException e){

		}
		Properties p = new Properties();
		p.setProperty("quizname"+((count-2)/2+1),fileName);
		p.setProperty("filename"+((count-2)/2+1),fileName+".csv");
		try{
			p.store(new FileWriter(f,true),"");
			File file = new File(fileName+".csv");
			file.createNewFile();
			deleteQuizSession(100);
		}catch(IOException e){

		}

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
	public void update(int select,int temp){
		int opt = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
			quizes.clear();
			
		
	}
	public void delete(int select){
			quizes.remove(select-1);
			write();
	}
	public void add(){
			read();
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
			quizes.clear();

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
	public List<String> getQuizSession(){
		Properties p = new Properties();
		List<String> quizSessions = new ArrayList<String>();
		try{
			p.load(new FileReader("QuizSession.properties"));
		}catch(Exception e){

		}
		for(int i = 1;i<11;i++){
			if(p.getProperty("quizname"+i) != null){
				quizSessions.add(p.getProperty("quizname"+i));
			}
		}
		return quizSessions;
	}
	public void deleteQuizSession(int selectedQuiz){
		File file = new File("QuizSession.properties");
		Properties p = new Properties();
		try{
			p.load(new FileReader("QuizSession.properties"));
		}
		catch(Exception e){

		}
		String fileName = p.getProperty("filename"+selectedQuiz);
		p.remove("filename"+selectedQuiz);
		p.remove("quizname"+selectedQuiz);
		try{
			p.store(new FileWriter(file),"");
		}catch(IOException e){

		}
		if(selectedQuiz!=100){
			File removeFile = new File(fileName);
			removeFile.delete();
		}
	}
} 