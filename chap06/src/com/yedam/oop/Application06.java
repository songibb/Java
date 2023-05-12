package com.yedam.oop;

public class Application06 {
	
	//필드 선언
	//int num = 1;
	static int num = 1;
	
	//메소드 선언
	
//	void info() {
//		System.out.println("info 출력");
//	}
	
	static void info() {
		System.out.println("info 출력");
	}
	
	void info2() {
		System.out.println("info2 출력");
	}

	public static void main(String[] args) {
		//int a = num + 1;  -> 오류 -> static으로 선언해야함

		//info(); -> 오류 -> static으로 선언해야함
		
	
		//자기 자신을 객체로 만든 예제 -> 절대로 하지 말 것
		Application06 app = new Application06();
		
		int a = app.num +1;
		
		app.info2();
		
		
		
		
		//클래스에 정의된 정적 멤버 사용  -> 어디에서든 공유 가능
		//클래스명.필드명 | 클래스명.메소드명
		System.out.println(StaticCal.PI);
		
		System.out.println(StaticCal.minus(10, 5));
		System.out.println(StaticCal.plus(10, 5));
		
		
	}

}
