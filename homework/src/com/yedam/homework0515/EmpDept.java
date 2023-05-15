package com.yedam.homework0515;

public class EmpDept extends Employee{
	String department;

	public EmpDept(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}
	
	public void getInformation() {
		System.out.println("이름:" + name + " 연봉:" + salary + " 부서:" + department);
	}
	
	public void print() {
		System.out.println("수퍼클래스 \n서브클래스");
	}
}
