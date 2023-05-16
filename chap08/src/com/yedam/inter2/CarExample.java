package com.yedam.inter2;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		
		System.out.println("타이어 교체 후===");
		myCar.frt = new HankookTire();
		myCar.run();

	}

}
