package com.yedam.exception;

public class Application01 {

	public static void main(String[] args) {
//		try {
//			//예외가 발생할만한 코드
//		} catch(예외종류) {
//			//예외, 문제가 발생했을 때 처리하는 코드
//		} finally {
//			//try 또는 catch문 실행하고 나서 무조건 실행하는 코드
//			//필수 아니고 선택   
//		}

		
		try{
			//분모가 0일때
			//double avg = 1/0;     -> 예외 발생시 아래 내용은 실행 안됨
			double avg = 1/1;
			System.out.println(avg);   
			
			//문자열 -> 정수
			//String str = "자바";
			String str = "1234";
			int a = Integer.parseInt(str);		
			
			//ClassNotFound
			Class clazz = Class.forName("java.lang.String2");
			
		} catch(ArithmeticException e) {
			System.out.println("숫자는 0으로 나눠서 예외 발생");
			e.printStackTrace();
		} catch(NumberFormatException e) {
			System.out.println("문자열 -> 정수 변환 실패");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("finally 항상 실행");
		}

		
		
		try {
			findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
		
	
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		} 

		
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}

}
