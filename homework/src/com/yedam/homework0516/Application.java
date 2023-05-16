package com.yedam.homework0516;

public class Application {

	public static void main(String[] args) {
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
		
	}

}
