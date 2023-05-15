package com.yedam.inheri;

public class Child extends Parent {
	//필드
	String name;
	
	//생성자
	
	//메소드
	
	@Override
	public void getInfo() {
		super.getInfo();   //super를 사용해 부모클래스에서 가진 getinfo()메소드를 가져옴
		method2(); //오버라이딩 되지 않은 메소드는 super를 사용하지 않고 그냥 가져올 수 있음
		System.out.println("나의 이름은 " + name + " 입니다.");
	}
	
	@Override
	public void method1() {
		super.getInfo();
		System.out.println("자식 객체의 method1 실행");
	}
	
	public void method3() {
		System.out.println("자식 객체의 method3 실행");
	}
}
