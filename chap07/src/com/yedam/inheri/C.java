package com.yedam.inheri;

import com.yedam.protect.A;

public class C extends A{
	
	//생성자를 이용
	public C() {
		super(); //부모 객체 생성 후 부모가 가진 필드와 메소드 접근
		this.field = "value";
		this.method();
	}
	
//	public void method2() {
//		A a = new A();  //다른 패키지 -> 객체에 있는 데이터가 protected로 제한이 걸려 있어 접근 안됨
//		a.field = "value";
//		a.method();
//	}
}
