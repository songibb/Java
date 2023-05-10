package com.yedam.loop;

import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		//for문
		//1~100까지의 수를 출력
		for(int i = 1; i<=100; i++) {
			System.out.println(i);
		}
		
		int result = 0;
		for(int i = 1; i<=100; i++) {
			result = result + i;
		}
		
		System.out.println("1~100사이의 합: " + result);

		//1~100사이의 짝, 홀수 구하기
		//숫자 % 2 == 0 -> 짝수
		//위의 경우가 아니라면 홀수
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0) {
				System.out.println(i + "는 짝수");
			} else if (!(i % 2 == 0)){
				System.out.println(i + "는 홀수");
			}
		}
		
		//입력한 숫자에 대한 구구단 출력
		Scanner sc = new Scanner(System.in);
		
		//2 -> 2*1=2, 2*2=4,...
		System.out.println("구구단 입력>");
		
		int gugu = Integer.parseInt(sc.nextLine());
		
		for(int i=1; i<=9 ;i++) {
			System.out.println(gugu + "*" + i + "=" + (gugu*i));
		}
		
		//입력한 값에 대한 총합, 평균, 최대값, 최소값 구하기
		//몇번 반복 값을 입력 받는다.
		//예시) 5번 -> 2,50,20,10,5
		
		//반복 횟수 입력
		System.out.println("반복 횟수>");
		int count = Integer.parseInt(sc.nextLine());
		
		int total = 0;
		int avg = 0; 
		int max = 0;
		int min = 0;
		
		
		for(int i=1; i<=count ;i++) {
			System.out.println("데이터 입력>");
			int data = Integer.parseInt(sc.nextLine());
			
			//총 합계 -> 데이터를 입력 받는대로 누적 합계
			total += data;
			
			if(i==0) {
				max = data;
				min = data;
			} else {
				//최대값 -> 최대값과 입력값을 비교 -> 더 큰 데이터
				if(max < data) {
					max = data;
				}
				//최소값 -> 최소값과 입력값을 비교 -> 더 작은 데이터
				if(min > data) {
					min = data;
				}
			}
		}
		//평균 -> 총 합계 / 반복문 횟수
		System.out.printf("평균 : %5.2f\n", (double)total/count);
		System.out.println("최대값 : " + max + " 최소값 : " + min);
		
		
		//임의의 랜덤 값 (1~100) 하나 추출
		//5번 기회(데이터를 입력->랜덤값 매칭) -> 데이터 입력(Scanner)
		//							  -> 입력값 VS 랜덤값 비교 (if)
		//							  ->
		//안에 해당 랜덤 값을 맞추는 프로그램 구현
		//예시) 랜덤 값 : 50
		//사용자 : 입력 -> 30
		//컴퓨터 : up
		//사용자 : 입력 -> 40
		//컴퓨터 : up
		//사용자 : 입력 -> 60
		//컴퓨터 : down
		
		//1) 맞춘 경우
		//정답입니다, 몇 번만에 맞추셨습니다.
		
		//2) 기회 안에 못 맞춘 경우
		//모든 기회를 소진하셨습니다. -> 반복문의 마지막 상황 -> i가 나올 수 있는 최대값인 경우
		//반복문 강제 종료 -> break;
		
		int randomNo = (int) (Math.random() * 100) + 1;
		
		for(int i=1; i<=5; i++) {
			//데이터 입력
			System.out.println("입력>");
			int userData = Integer.parseInt(sc.nextLine());
			if(userData == randomNo) {
				System.out.printf("정답입니다. %d 번만에 맞추셨습니다", i);
				break;
			} else if(userData > randomNo) {
				System.out.println("Down");
			} else if(userData < randomNo) {
				System.out.println("Up");
			} if(i == 5) {
				System.out.println("모든 기회를 소진하셨습니다");	
			}
			
		}
		
		
		
		
		
	}

}
