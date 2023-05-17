package com.yedam.homework0517;

import java.util.Scanner;

public class StringGame {

	//필드 
//	String orange = "orange";
//	String game = "game";
//	String phone = "phone";
//	String smart = "smart";
	String charData;
	
	//생성자
	StringGame(){
		
	}
	
	//메소드
	
	//문자하나 : 문자 단위로 입력을 받으며 정답에 포함된 문자인지 확인
	Scanner sc = new Scanner(System.in);
	
	public void setCharData() {
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		
		System.out.println("입력 값>");
		charData = sc.nextLine();

	}

	
	//단어    : 단어 단위로 입력을 받으며 정답인지 확인
	public void setStrData() {
		
	}
	//입력내역 : 게임이 진행되는 동안 입력된 문자를 입력 순으로 출력
	public void showCharData() {
		
	}
	//새 게임  : 기존에 선택한 단어 대신 랜덤으로 새 단어를 선택하며 입력내역을 초기화
	public void init() {
		
	}
}
