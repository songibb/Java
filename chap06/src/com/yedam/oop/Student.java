package com.yedam.oop;

public class Student {
	//학생의 정보를 관리하는 프로그램
	//학생의 정보를 관리하는 객체
	//이름, 학년, 국어, 영어, 수학
	String name;
	String grade;
	int kor;
	int eng;
	int math;
	
	//기본 생성자
	Student(){
		
	}
	
//	Student(String name, String grade, int kor, int eng, int math){
//		this.name = name;
//		this.grade = grade;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//	}
	
	//메소드
	//모든 정보를 출력 getInfo()
	void getInfo() {
		System.out.println(
				"1) 이름 : " + name +
				"\n2) 학년 : " + grade +
				"\n3) 국어 : " + kor +
				"\n4) 영어 : " + eng +
				"\n5) 수학 : " + math);
	}
	

}
