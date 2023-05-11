package com.yedam.oop;

public class Bycle {
	//필드
	int gas;
	//생성자
	
	//메소드
	void setGas(int gas) {
		this.gas = gas;
	}   //메소드를 활용한 필드 초기화
	
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("달립니다.(gas잔량 :" + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas잔량 :" + gas + ")");
				return;  //return 뒤에 데이터 없이 사용하면 메소드 강제종료
			}
		}
	}
}
