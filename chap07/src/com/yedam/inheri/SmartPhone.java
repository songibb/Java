package com.yedam.inheri;

public class SmartPhone extends CellPhone{
	//필드
	String agency;
	
	//생성자  -> 부모가 가진 필드를 사용
	SmartPhone(String model, String color, String agency){
		//부모 생성자 호출 -> 부모 클래스를 객체로 생성 한 뒤 자식클래스를 객체로 생성 
		super();  //super(); -> 생략가능
		
		System.out.println("자식 객체 생성중");
		this.model = model;
		this.color = color;
		this.agency = agency;
	}
	
	SmartPhone(String model, String color){
		super(model);  //부모 클래스에 만들어 놓은 생성자 중 매개변수 들어가는 생성자로 선택해서, 부모 객체를 생성
		this.color = color;
		this.agency= "KT";
	}
	
	//메소드
	
	
	void kakaoExe() {
		System.out.println("카카오톡을 실행합니다");
	}
	void Info() {
		System.out.println("통신사 : " + agency + "입니다");
	}
	void kakaoExit() {
		System.out.println("카카오톡을 종료합니다");
	}
}
