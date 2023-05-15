package com.yedam.poly;

public class CastingExample {
	public static void main(String[] args) {
		//강제 타입 변환
		//부모 타입으로 만들어진 객체(다형성) -> 부모만 가지고 있는 내용을 사용
		//자식이 가지고 있는 필드, 메소드를 사용하고자 할 때
		//1) 자동 타입 변환
		//2) 타입 변환시 사용했던 자식 클래스를 사용
	
		//자동 타입 변환
		Parent p1 = new Child();
		
		p1.field = "부모필드";
		p1.method1();
		p1.method2();
		
		System.out.println("===============");
		
		//강제 타입 변환
		Child child = (Child) p1;
		child.field = "부모필드";
		child.method1();
		child.method2();	//부모 필드와 메소드 사용가능
		
		child.field2 = "asdfa";
		child.method3();	//자식 필드와 메소드도 사용가능
		
		
		
		Parent p2 = new Parent();
		
		if(p2 instanceof Child02) {
			Child02 c2 = (Child02) p2;
		} else {
			System.out.println("Child02로 자동 타입 변환 하지 않음");
		}
		
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);
//		method2(parentB);  -> ClassCastException 오류
		
		
		
		GrandPa gp = new Child();
		gp.method10();
		
		
	}
	
	
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1-child 변환 성공");
		} else {
			System.out.println("method1-child 변환 실패");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child) parent;
		System.out.println("method2-child 변환 성공");
	}
	
}
