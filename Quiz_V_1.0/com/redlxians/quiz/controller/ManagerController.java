package com.redlxians.quiz.controller;

import java.io;
/**
*@author Mohammed Anish
*/
public class ManagerController{

	File f = new File("Quiz.csv");
	FileReader fw = new FileReader(f);
	BufferedReader bw = new BufferedReader(fw);

	public void create(){
		System.out.println("create");
	}
	public void read(){
		
	}
	public void update(){
		
	}
	public void delete(){

	}
} 