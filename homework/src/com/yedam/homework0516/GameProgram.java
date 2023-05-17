package com.yedam.homework0516;

import java.util.Scanner;

public class GameProgram {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int randomGame = (int)(Math.random()*2);
		
		boolean run = true;
		int selectNo;
		Keypad kp2;
		
		if(randomGame == 0) {
			kp2 = new RPGgame();
		} else {
			kp2 = new ArcadeGame();
		}
		
		while(run) {
			System.out.println("============================================================================================");
			System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.println("============================================================================================");
			
			System.out.println("choice>>");
			selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo){
			case 1:
				kp2.leftUpButton();
				break;
			case 2:
				kp2.leftDownButton();
				break;
			case 3:
				kp2.rightUpButton();
				break;
			case 4:
				kp2.rightDownButton();
				break;
			case 5:
				kp2.changeMode();
				break;
			case 0:
				if(kp2 instanceof RPGgame) {
					kp2 = new ArcadeGame();
				} else {
					kp2 = new RPGgame();
				}
				break;
			case 9:
				run = false;
				System.out.println("EXIT");	
				break;
			}
		}
		
		
	}
}
