package com.yedam.homework0517;

import java.util.Scanner;

public class StringGame {

	//필드 
	String answer;
	char charData;
	String result="";
	String wordData;
	String ox="";
	
	//생성자
	StringGame(){
		int randomWord = (int)(Math.random() * 4) + 1;
		switch(randomWord) {
		case 1:
			answer = "orange";
			break;
		case 2:
			answer = "game";
			break;
		case 3:
			answer = "phone";
			break;
		case 4:
			answer = "smart";
			break;
		}
	}
	
	//메소드
	
	//문자하나 : 문자 단위로 입력을 받으며 정답에 포함된 문자인지 확인
	Scanner sc = new Scanner(System.in);
	
	public void setCharData() {
		
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		System.out.println(result);
		System.out.print("입력 값>");
		charData = sc.nextLine().charAt(0);
		
		for (int i = 0; i<answer.length();i++) {
			if(charData == answer.charAt(i)) {		
				result += answer.charAt(i);
				System.out.println("문자열을 구성하는 문자입니다.");
			} 
		}
		
		if(answer.length() == result.length()) {
			System.out.println("문자열을 구성하는 문자를 다 입력하셨습니다");
			
		}
		
	}
		
	
	//단어    : 단어 단위로 입력을 받으며 정답인지 확인
	public void setStrData() {
		
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		System.out.println(result);
		System.out.print("입력 값>");
		wordData = sc.nextLine();
		
		for (int i = 0; i<answer.length();i++) {
			if(answer.length() != wordData.length()) {
				System.out.println("입력된 문자열의 길이가 정답과 다릅니다.");	
				break;
			}
			if(wordData.charAt(i) == answer.charAt(i)) {
				ox += "O";
			} else {
				ox += "X";
			} 
		}
		
		if (ox.equals("OOOO") || ox.equals("OOOOO") || ox.equals("OOOOOO")) {
			System.out.println("정답입니다.");
		} else {
			System.out.println(ox);
		}
		
	}
	//입력내역 : 게임이 진행되는 동안 입력된 문자를 입력 순으로 출력
	public void showCharData() {
		
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		System.out.println(result);

	}
	//새 게임  : 기존에 선택한 단어 대신 랜덤으로 새 단어를 선택하며 입력내역을 초기화
	public void init() {
		

	}
}
