package com.yedam.homework0516;

public class Application {

	public static void main(String[] args) {
		
		//Q1
		Keypad kp = new RPGgame();
		kp.leftUpButton();
		kp.rightUpButton();
		kp.changeMode();
		kp.rightUpButton();
		kp.rightDownButton();
		kp.leftDownButton();
		kp.changeMode();
		kp.rightDownButton();
		
		System.out.println("======================");
		kp = new ArcadeGame();
		kp.leftUpButton();
		kp.rightUpButton();
		kp.leftDownButton();
		kp.changeMode();
		kp.rightUpButton();
		kp.leftUpButton();
		kp.rightDownButton();
		
		System.out.println();
		
		//Q2
		PortableNotebook pn = new PortableNotebook("한글2020", "크롬", "영화", "안드로이드앱");
		pn.writeDocumentation();
		pn.watchVideo();
		pn.changeMode();
		pn.useApp();
		pn.searchInternet();
		
		System.out.println();
		
		
		
		
		
	}

}
