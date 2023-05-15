package com.yedam.poly;

public class Tire {
	// 필드
	public int maxRotation;  //타이어 수명
	public int accumulateRotation;  //누적 사용횟수
	public String location;  //타이어 위치

	// 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}

	// 메소드
	public boolean roll() {
		++accumulateRotation;  //roll() 한번 실행할 때 마다 누적횟수 +!
		if (accumulateRotation < maxRotation) {
			System.out.println(location + " Tire 수명 :" + (maxRotation - accumulateRotation) + "회");
			return true;
		}else {
			System.out.println("*** " + location + " Tire 펑크");
			return false;
		}
	}

}