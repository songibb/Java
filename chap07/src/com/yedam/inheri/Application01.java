package com.yedam.inheri;

public class Application01 {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("아이폰", "스그", "SK"); //부모 객체 만들지 않아도 먼저 생성되고 자식 객체 생성됨
		
		//CellPhone(부모) Class 필드 사용
		System.out.println("모델: "+ sp.model);
		System.out.println("색상: " +sp.color);
		
		//SmartPhone(자식) Class 필드 사용
		System.out.println("통신사: " + sp.agency);
	
		//CellPhone(부모) Class 메소드 사용
		sp.powerOn();
		sp.bell();
		sp.hangUp();
		sp.powerOff();
		
		//SmartPhone(자식) Class 메소드 사용
		sp.kakaoExe();
		sp.kakaoExit();
		sp.Info();
	
	}

}
