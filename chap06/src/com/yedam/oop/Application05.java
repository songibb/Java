package com.yedam.oop;

import java.util.Scanner;

public class Application05 {

	public static void main(String[] args) {
		//학생의 정보를 관리하는 프로그램
		//학생의 정보를 관리하는 객체
		//이름, 학년, 국어, 영어, 수학
		
		//기본 생성자
		
		//메소드
		//모든 정보를 출력 getInfo()
		
		//1. 학생수
		//2. 정보 입력
		//3. 정보 확인
		//4. 분석 - 전체 학생의 점수를 총합(국+영+수)
		//		 - 총합의 평균(학생수의 평균)
		//		 - 개인별 가장 점수가 높은 과목 / 낮은 과목
		//5. 종료
		
		
		//학생 정보를 담는 배열
		Student[] stuArr = null;
		
		//학생수 담는 변수
		int stuNum = 0;

		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("=================================================");
			System.out.println("1. 학생수 | 2. 정보 입력 | 3. 정보 확인 | 4. 분석 | 5. 종료");
			System.out.println("=================================================");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo==1) {
				System.out.println("학생 수>");
				stuNum = Integer.parseInt(sc.nextLine());
			} else if(selectNo==2) {
				stuArr = new Student[stuNum];
				
				//학생 정보 입력
				for(int i = 0; i<stuArr.length; i++) {
					Student student = new Student();
					
//					System.out.println("이름>");
//					student.name = sc.nextLine();
//					System.out.println("학년>");
//					student.grade = sc.nextLine();
//					System.out.println("국어>");
//					student.kor = Integer.parseInt(sc.nextLine());
//					System.out.println("영어>");
//					student.eng = Integer.parseInt(sc.nextLine());
//					System.out.println("수학>");
//					student.math = Integer.parseInt(sc.nextLine());
//					
//					stuArr[i] = student;
					
					//배열에 바로 객체를 만드는 방법
					stuArr[i] = new Student();
					
					System.out.println("이름>");
					stuArr[i].name = sc.nextLine();
					System.out.println("학년>");
					stuArr[i].grade = sc.nextLine();
					System.out.println("국어>");
					stuArr[i].kor = Integer.parseInt(sc.nextLine());
					System.out.println("영어>");
					stuArr[i].eng = Integer.parseInt(sc.nextLine());
					System.out.println("수학>");
					stuArr[i].math = Integer.parseInt(sc.nextLine());
					
					
				}
			} else if(selectNo==3) {
				for(int i = 0; i<stuArr.length; i++) {
					System.out.println((i+1)+"번째 학생");
					stuArr[i].getInfo();
					System.out.println();
				}
				
			} else if(selectNo==4) {
				int total = 0;
				int max = 0;
				int min = 0;
				for(int i =0; i<stuArr.length; i++) {
					//누적 합계
					int sum = 0;
					sum = stuArr[i].kor + stuArr[i].eng + stuArr[i].math;
					total = total + sum;

					max = stuArr[i].kor;
					min = stuArr[i].kor;
					
					//최대값
					if(stuArr[i].eng < stuArr[i].math) {
						if(max < stuArr[i].math) {
							max = stuArr[i].math;
						}
					} else {
						if(max < stuArr[i].eng) {
							max = stuArr[i].eng;
						}
					}
					//최소값
					
				}
				
				System.out.println("총합 : " + total);
				System.out.println("평균 : " + (double)total/stuNum);

			} else if(selectNo==5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
