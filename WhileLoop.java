package com.yedam.loop;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {
		
		//짝수 구하는 for문
		for (int i = 1; i<=100; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
		
		//짝수 구하는 while문
		int i = 1;
		while(i<=100) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		//계산기 프로그램
		//무한 루프 
		//어떠한 조건 -> 프로그램 종료
		
		//1) 변수 활용
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("입력>");
			
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				System.out.println("더하고자 하는 두 수 입력");
				System.out.println("1>");
				int num1 = Integer.parseInt(sc.nextLine());
				System.out.println("2>");
				int num2 = Integer.parseInt(sc.nextLine());
				
				System.out.println(num1 + " + " + num2 + " 의 결과 " + (num1+num2));
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
		
		//2) break
		while(true) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("입력>");
			
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				
			} else if(num == 2) {
				
			} else if(num == 3) {
				
			} else if(num == 4) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		//3) while 조건식에 비교문 사용
		int num = 0;
		while(num != 4) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("입력>");
			
			num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				
			} else if(num == 2) {
				
			} else if(num == 3) {
				
			} else if(num == 4) {
				System.out.println("프로그램 종료");
				
			}
		}
		
		
		
		//오락실 만들기
		//오락 한 번 -> 500원
		//1500원 투입 -> 3번
		System.out.println("===insert coin===");
		int money = Integer.parseInt(sc.nextLine());  //500, 700
		
		while(money > 500) {
			//몫을 활용해서 게임의 기회 -> 1500/500 -> 3
			System.out.println((money/500) + "번 기회 남았습니다.");
			System.out.println("1. 가위바위보 | 2. UP & Down | 3. 종료");
			
			System.out.println("메뉴 입력>");
			int gameNo = Integer.parseInt(sc.nextLine());
			
			switch(gameNo) {
			case 1:
				System.out.println("가위바위보 진행"); 
				money = money - 500;
				break;
			case 2:
				System.out.println("UP & Down");
				money = money - 500;
				break;
			case 3:
				System.out.println("종료");
				//money가 500보다 작은 금액으로 변경
				money = 400;
				break;
			}
		}
		
		
		int month;
		
		do {
			System.out.println("올바른 월을 입력하세요[1-12]");
			month = sc.nextInt();
		} while(month < 1 || month > 12);
		
		System.out.println("사용자가 입력한 월은 " + month);
	}

}
