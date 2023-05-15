package com.yedam.inheri;

public class Computer extends Calculator {

	@Override  //@ : 어노테이션 -> 자바한테 프로그램 실행전에 알려주는 것
	double areaCircle(double r) {
		System.out.println("Computer 객체의 메소드 실행");
		return Math.PI * r *r;
	}
}
