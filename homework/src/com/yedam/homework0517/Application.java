package com.yedam.homework0517;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String answer;
		int randomWord = (int)(Math.random()*4)+1;
		if(randomWord == 1) {
			answer = "orange";
		} else if(randomWord == 2) {
			answer = "game";
		} else if(randomWord == 3) {
			answer = "phone";
		} else {
			answer = "smart";
		}
		
		boolean run = true;
		StringGame game = new StringGame();
		
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println(" 1.문자하나 | 2.단어 | 3.입력내역 | 4.새 게임 | 5.종료 ");
			System.out.println("---------------------------------------------");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				game.setCharData();
				break;
			case 2:
				game.setStrData();
				break;
			case 3:
				game.showCharData();
				break;
			case 4:
				game.init();
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다.");
			
			}
		}
	}

}
