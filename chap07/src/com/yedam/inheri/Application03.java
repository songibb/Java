package com.yedam.inheri;

public class Application03 {

	public static void main(String[] args) {
		int r = 10;
		
		Computer com = new Computer();
		System.out.println("원 면적: "+ com.areaCircle(r));

		
		
		Child child = new Child();
		
		//부모 객체
		child.getInfo();  //오버라이딩 메소드 가져옴
		child.method1();  //오버라이딩 메소드 가져옴
		child.method2();  //오버라이딩 하지 않아서 부모 객체의 메소드 가져옴
		
		//자식 객체
		child.method3();  
		
		
		System.out.println("=============");
		
		SupersonicAirPlane sa = new SupersonicAirPlane();
		sa.takeOfF();
		sa.fly();
		sa.flyMode = SupersonicAirPlane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicAirPlane.NORMAL;
		sa.fly();
		sa.land();
		
	}

}
