package com.yedam.homework0517_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringGame {
	private String[] strData = {"Orange", "Game", "Phone", "Smart"};
	private String strAnswer;  //랜덤으로 뽑은 단어
	private List<Character> charData;  //랜덤으로 뽑은 단어 중에 입력한 문자가 존재한다면 list에 보관
	
	public StringGame(){
		init();
	}
	
	public void setCharData() {
		showStrData();
		//list의 길이와 문자열의 길이 같다면 단어가 가진 문자는 다 찾았다.
		if(charData.size() == strAnswer.length()) {
			System.out.println("문자열을 구성하는 문자를 다 입력하셨습니다");
		} else {
			String inputStr = inputData();
			if(strAnswer.indexOf(inputStr.charAt(0)) != -1) {   //입력한 글자의 첫번째 글자만 비교  //-1이 아니라면 포함되어있다는 뜻
				System.out.println("문자열을 구성하는 문자입니다.");
				charData.add(inputStr.charAt(0));
			} else {
				System.out.println("문자열을 구성하는 문자가 아닙니다.");
			}
		}
			
	}

	public void showStrData() {
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		for(int i=0; i<charData.size(); i++) {
			System.out.println(charData.get(i) + " ");
		}
		
//		향상된 for문 이용시
//		for(char data : charData) {
//			System.out.print(data + " ");
//		}
		
		System.out.println();
		
	}

	private String inputData() {
		System.out.println("입력값>");
		
//		Scanner sc = new Scanner(System.in);
//		String word = sc.nextLine().toLowerCase();
		return new Scanner(System.in).nextLine().toLowerCase();  //scanner에 입력받은 데이터를 
	}

	public void setStrData() {
		showStrData();
		
		String inputStr = inputData();
		if(strAnswer.equals(inputStr)) {
			System.out.println("정답입니다.");
		} else {
			showStrData(inputStr);
		}
	}

	private void showStrData(String inputStr) {
		if(strAnswer.length()==inputStr.length()) {
			for(int i = 0; i<strAnswer.length(); i++) {
				if(strAnswer.charAt(i) == inputStr.charAt(i)) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		} else {
			System.out.println("입력된 문자열의 길이가 정답과 다릅니다.");
		}
		
	}


	public void init() {
		//랜덤 단어
		strAnswer = getStrAnswer();
		
		//입력한 내역 초기화
		charData = new ArrayList<>();
	}

	private String getStrAnswer() {
		int idx = (int)(Math.random() * 4);
		String str = strData[idx].toLowerCase(); 
		return str;
	}

	
	
	
}
