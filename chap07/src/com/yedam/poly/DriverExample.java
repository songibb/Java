package com.yedam.poly;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		//1)new Taxi()를 변수에 담아서 매개변수에 넣기
		Taxi taxi = new Taxi();
		driver.drive(taxi);

		//2)new Bus() 자체로 매개변수에 넣기
		driver.drive(new Bus());
	}

}