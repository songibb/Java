package com.yedam.homework;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//문제1
		//변수 두개를 선언해서 10과 2.0을 대입하고 두 변수의 사칙 연산 결과를 정수로 출력하는 코드를 작성하세요
		int x = 10;
		double y = 2.0;
		
		System.out.println(x+(int)y);
		System.out.println(x-(int)y);
		System.out.println(x*(int)y);
		System.out.println(x/(int)y);
		
		
		//문제2
		int num1 = 10;
		int num2 = 20;
		boolean result;
		
		result = ((num1 > 10) && (num2 > 10));
		System.out.println(result);  //(1) false
		
		result = ((num1 > 10) || (num2 > 10));
		System.out.println(result);  //(2) true
		System.out.println(!result);   //(3) false
		
		
		
		
		//문제3
		//주어진 금액을 동전으로 바꾸었을 때 몇 개의 동전이 필요한지 프로그램을 구현
		//큰 금액부터 동전을 우선적으로 거슬러 줘야한다.
		int[] coinUnit = {500,100,50,10};
		int money = 2680;
		System.out.println("money=" + money);
		
		for(int i=0; i <coinUnit.length; i++) {
			//내가 푼 부분
//			int coin = 0;
//			coin = money/coinUnit[i];
//			money = money - coinUnit[i]*coin;
//
//			int[] coinArr = new int[coinUnit.length];
//			coinArr[i] = coin;
//			System.out.println(coinUnit[i]+"원" +" : "+coinArr[i]+"개");
			
			//교수님 정답
			System.out.println(coinUnit[i]+"원 : "+(money/coinUnit[i])+"개");
			money = money%coinUnit[i];
			
		}
		
		

		
		//문제4
		//구구단을 단보다 곱하는 수가 작거나 같은 경우끼리만 출력하는 프로그램 작성
		//내가 푼 부분
//		for (int i = 2; i<10; i++) {
//			for (int j = 1; j<10; j++) {
//				if(i >= j) {
//				System.out.println(i + "X" + j + "=" + i*j);
//				}
//			}
//		}
		
		//교수님 정답
		for (int i = 2; i<10; i++) {
			for (int j = 1; j<=i; j++) {			
				System.out.println(i + "X" + j + "=" + i*j);
			}
		}
				
		//문제5
		//메뉴1 - 주사위 크기(5~10)를 입력받으세요.(주사위가 몇면체인지 정하는 것) 범위를 벗어날 경우 범위안내 메세지를 출력.
		//메뉴2 - 5가 나올 때까지 주사위를 몇번 굴리는 지 구하고 출력
		//메뉴3 - 메뉴2에서 각 주사위 수별로 몇 번씩 나왔는지 출력
		//메뉴4 - 메뉴2에서 가장 많이 나온 수가 몇인지 구하고 출력. 가장 많이 나온 수가 여러 개일 경우 가장 작은 수가 출력
		//메뉴5 - 프로그램 종료
		Scanner sc = new Scanner(System.in);
		
//		int diceSize = 0;
//		int count = 0;
//		int number = 0;
//		int[] numArr = null;
//	
//		while(true) {
//			System.out.println("===1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료 ===");
//			System.out.println("메뉴>");
//			int selectNo = Integer.parseInt(sc.nextLine());
//			
//			if(selectNo==1) {
//				
//				System.out.println("주사위 크기>");
//				
//				diceSize = Integer.parseInt(sc.nextLine());
//				if (diceSize < 5 || diceSize >10) {
//					System.out.println("범위를 벗어났습니다.");
//				}
//				
//			} else if(selectNo==2) {
//				
//				while(true) {
//					number = (int) (Math.random()*diceSize) +1;
//					System.out.println(number);
//					numArr = new int[count+1];
//					count++;
//					for(int i = 0; i<count; i++) {
//						numArr[i] = number;
//					} 
//	
//					if(number == 5) {
//						System.out.println("5가 나올때까지 주사위를 " + count + "번 굴렸습니다");
//						break;
//					}
//				}
//
//			} else if(selectNo==3) {
//				for(int i = 0; i<numArr.length; i++) {
//					System.out.println(numArr[i]);
//					
//				}
//			} else if(selectNo==4) {
//				
//			} else if(selectNo==5) {
//				System.out.println("프로그램 종료");
//				break;
//			} 
//			
//		}
		
		//주사위 배열
		int[] dice = null;
		//주사위 크기를 결정하는 변수
		int diceNo = 0;
		//메뉴 선택 변수
		int selectNo = 0;
		while(selectNo !=5) {
			System.out.println("===1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료 ===");
			System.out.println("메뉴>");
			
			selectNo = Integer.parseInt(sc.nextLine());
			switch(selectNo) {
			case 1:
				System.out.println("주사위 크기>");
				diceNo = Integer.parseInt(sc.nextLine());
				if(diceNo < 5 || diceNo >10) {
					System.out.println("범위를 벗어났습니다.");
					System.out.println("5~10 사이의 숫자를 입력하세요");
					
					//2번 주사위 굴릴 때 사용
					diceNo = 0;
				}
				break;
			case 2:
				//만약 주사위 크기가 제대로 입력되지 않았다면
				if(diceNo == 0) {
					System.out.println("주사위 번호가 입력되지 않음");
					System.out.println("다시 입력하세요");
				} else {
					
					//주사위 배열 생성
					dice = new int[diceNo];
					//주사위 굴린 횟수
					int count = 0;
					
					while(true) {
						//주사위 굴린 횟수 증가
						count++;
						//주사위 굴려서 나오는 랜덤값
						int randomDice = (int)(Math.random()*diceNo)+1;
						//랜덤값을 활용하여 dice배열의 인덱스를 구한 뒤 1씩 증가
						dice[randomDice-1]++;
						if(randomDice == 5) {
							System.out.println("5가 나올 때까지 " + count + "번 굴렸습니다.");
							break;
						}
					}				
				}
				
				
				break;
			case 3:
				for (int i = 0; i<dice.length; i++) {
					System.out.println((i+1) + "은 " + dice[i] + "번 나왔습니다.");
				}
				break;
			case 4:
				//가장 많이 나온 수가 여러 개일 경우 주사위 눈 중 가장 큰 수가 출력
				int max = dice[dice.length-1]; //배열 끝에서부터 비교  ->  주사위 눈 중 가장 큰 수
				int idx = 0;
				for(int i=dice.length-1; i>=0; i--) {
					if(max < dice[i]) {
						max = dice[i];
						idx = i+1;
					}
				}
				//가장 많이 나온 수가 여러 개일 경우 주사위 눈 중 가장 작은 수가 출력
//				int max = dice[0]; //배열 끝에서부터 비교  -> 주사위 눈 중 가장 작은 수
//				int idx = 0;
//				for(int i=0; i<dice.length; i++) {
//					if(max < dice[i]) {
//						max = dice[i];
//						idx = i+1;
//					}
//				}
				System.out.println("가장 많이 나온 수는 " + idx + "입니다.");
				break;
			case 5:
				System.out.println("프로그램 종료");
				break;
			}
		}
				
	}
}
