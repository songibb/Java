package com.yedam.oop;

public class Application01 {
	//실행 클래스
	public static void main(String[] args) {
		//Car Class => 객체
		Car myCar = new Car(); //Car 클래스를 사용하기 위해 객체를 만든 것 
		//dot,, . (도트연산자) -> 클래스가 가지고 있는 필드를 가져올수 있음
		System.out.println(myCar.company); //클래스 내부의 필드에 미리 입력되어 있는 데이터 "벤틀리"가 출력됨
		System.out.println(myCar.price);
		System.out.println(myCar.name);
		
		//클래스 외부에서 객체를 생성하고 필드를 호출하여 데이터 입력
		System.out.println("===객체 필드 데이터 입력===");
		myCar.company = "현대";  //기존의 데이터 "벤틀리"에서 "현대"로 변경
		myCar.price = 1234;
		myCar.name = "소나타";
		System.out.println(myCar.company);
		System.out.println(myCar.price);
		System.out.println(myCar.name);
		
		Car yourCar = new Car();  //myCar와 별개로 새로 객체를 생성, Car라는 타입의 필드를 동일하게 사용가능
		System.out.println("===myCar와 yourCar 비교===");
		System.out.println(myCar.company);
		System.out.println(yourCar.company);
		
		
		
		System.out.println("===Korean Class를 활용한 객체 생성===");
		Korean k1 = new Korean("박자바","011225-1234567");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		
		
		System.out.println("===생성자 오버로딩을 활용한 객체 생성===");
		
		//매개변수가 하나인 생성자 활용
		Car oneCar = new Car("소나타");
		System.out.println("oneCar의 필드 name : " + oneCar.name);
		
		Car threeCar = new Car("그랜저", 300, "현대");
		System.out.println("ThreeCar의 필드 : " + threeCar.name);
		System.out.println("ThreeCar의 필드 : " + threeCar.price);
		System.out.println("ThreeCar의 필드 : " + threeCar.company);
		
		
		
		oneCar.run();
		System.out.println(oneCar.info());
		
		
		
		
		
	}
}
