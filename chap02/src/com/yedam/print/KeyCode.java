package com.yedam.print;

import java.io.IOException;
import java.util.Scanner;

public class KeyCode {
	public static void main(String[] args) throws IOException {
		//KeyCode -> 하나의 문자만 받아올 때
		System.out.println("입력>");
		
		int keyCode = 0;
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		keyCode = System.in.read();
		System.out.println("KeyCode : " + keyCode);
		
		
		//Scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력>");
		
		//nextLine -> 문자열 읽을 때 사용 -> 데이터와 enter를 인식 후 enter키는 소멸됨
		//enter키 이전까지 데이터를 받아 옴
		//enter키 기준으로 데이터를 읽어 옴
		String inputData = scanner.nextLine();
		
		//nextInt -> 정수 읽을 때 사용 -> 데이터와 enter를 인식 후 enter키가 console에 남아있음
		int data = scanner.nextInt();
		
		//enter 소멸
		scanner.nextLine();
		
		inputData = scanner.nextLine();  //enter소멸 시켜주지 않으면 남아있는 enter키 빈데이터가 입력됨 -> 데이터 입력 안받음
		
		System.out.println("Scanner 활용 -> " + inputData);
		
		
		
		//데이터 비교 -> 입력한 값 == 저장된 값 비교
		
		//기본 타입(정수, 실수) -> ==
		//문자열 -> equals
		if(inputData.equals("yedam")) {
			System.out.println("yedam과 일치합니다.");
		}
	}
}
