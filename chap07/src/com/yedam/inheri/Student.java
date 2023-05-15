package com.yedam.inheri;

public class Student extends People{

	int stdNo;
	
	
	//부모 클래스에 매개변수가 있는 생성자가 있다면, 자식 클래스에서도 반드시 포함해서 생성해야함
	public Student(String name, String ssn, int stdNo) {
		super(name, ssn);
		this.stdNo = stdNo;
	}  

}
