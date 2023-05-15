package com.yedam.homework0515;

public class Employee {
	//필드
	String name;
	int salary;
	
	//생성자
	public Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	//메소드
	public void getInformation() {
		System.out.println("이름:"+ name);
		System.out.println("연봉:" + salary);
	}
	public void print() {
		System.out.println("수퍼클래스");
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}

}
