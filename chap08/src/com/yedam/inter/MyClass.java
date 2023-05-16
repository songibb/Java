package com.yedam.inter;

public class MyClass {
	//인터페이스 사용 할 수 있는 공간
	//필드
	RemoteControl rc = new Television();
	
	//생성자
	public MyClass() {
		
	}
	public MyClass(RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.turnOff();
	}
	
	//메소드
	public void methodA() {
		//로컬 변수 사용
		RemoteControl rc = new Audio();   //필드나 생성자의 rc와 다른 rc임. methodA에서만 사용.
		rc.turnOn();
		rc.turnOff();
	}
	
	//메소드의 매개 변수
	public void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(4);
		rc.turnOff();
	}
	
	
}
