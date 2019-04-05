package com.redlxians.quiz.view;

import java.util.*;
import com.redlxians.quiz.controller.ManagerController;
/**
*@author Mohammed Anish
*/
public class ManagerView{
	static Scanner scan = new Scanner(System.in);
	ManagerController manager = new ManagerController();
	public void managerOptions(){

		int option;
		System.out.println("1.Create\n2.Read\n3.Update\n4.Delete");
		option = scan.nextInt();
		switch(option){
			case 1:
			manager.create();
			break;
			case 2:
			manager.read();
			break;
			case 3:
			manager.update();
			break;
			case 4:
			manager.delete();
			break;
		}

	}
}