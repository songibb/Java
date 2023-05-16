package com.yedam.homework0516;

import java.util.Scanner;

public class GameProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int randomGame = (int)(Math.random()*2);
		
		boolean run = true;
		int selectNo;

		if(randomGame == 0) {
			Keypad kp = new RPGgame();
			while(run) {
				System.out.println("============================================================================================");
				System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
				System.out.println("============================================================================================");
				
				System.out.println("choice>>");
				selectNo = Integer.parseInt(sc.nextLine());
				
				switch(selectNo){
				case 1:
					kp.leftUpButton();
					break;
				case 2:
					kp.leftDownButton();
					break;
				case 3:
					kp.rightUpButton();
					break;
				case 4:
					kp.rightDownButton();
					break;
				case 5:
					kp.changeMode();
					break;
				case 0:
					break;
				case 9:
					System.out.println("EXIT");
					break;
				}
			}
			
		
		} else {		
			Keypad kp = new ArcadeGame();
			while(run) {
				System.out.println("============================================================================================");
				System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
				System.out.println("============================================================================================");
				
				System.out.println("choice>>");
				selectNo = Integer.parseInt(sc.nextLine());
				
				switch(selectNo){
				case 1:
					kp.leftUpButton();
					break;
				case 2:
					kp.leftDownButton();
					break;
				case 3:
					kp.rightUpButton();
					break;
				case 4:
					kp.rightDownButton();
					break;
				case 5:
					kp.changeMode();
					break;
				case 0:
					break;
				case 9:
					System.out.println("EXIT");
					break;
				}
			}
			
		}
		
		
	}
}
