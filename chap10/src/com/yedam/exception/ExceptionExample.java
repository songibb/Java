package com.yedam.exception;

public class ExceptionExample {

	public static void main(String[] args) {
		//NullPointerException
//		String data = null;
//		System.out.println(data.length());

		
		
		//ArrayIndexOutOfBoundsException
		int[] intAry = new int[3];  //0~2
		
		intAry[0] = 1;
//		intAry[10] = 10;
		
//		for(int i = 0; i<intAry.length; i++) {   //인덱스의 범위를 벗어남
//			System.out.println(intAry[i]);
//		}
		
		
		
		//NumberFormatException
		//바꿀 수 없는 숫자인데 바꾸려고 할 때
		String str = "123";
		int val = Integer.parseInt(str);
		System.out.println(val);
		
		//예외
//		String str2 = "자바";
//		val = Integer.parseInt(str2);
//		System.out.println(val);
		
//		String str3 = "";
//		val = Integer.parseInt(str3);
//		System.out.println(val);

		
		
		//ClassCastException
		//자동타입변환이 된 객체타입변환 발생
		
		//정상
		Example exam = new Exam();
		Exam exam02 = (Exam) exam;
		
		//예외
		Example exam03 = new Example();
		//Exam exam04 = (Exam) exam03;
				
		if(exam03 instanceof Exam) {
			Exam exam04 = (Exam) exam03;
		}
		
		//ClassNotFoundException -> Class파일(JAVA)을 찾지 못할 때
		//실행 메소드 -> main을 찾지 못할 때
		//Java파일을 찾아야 하는데 못찾는 경우
		
		
		
		//ArithmeticException -> 분모가 0일때
		//double a = 1/0;
		
		
		
		//IOExeption -> 입출력 오류
		//file reading or write
		
		
		
		//FileNotFoundException
		//java -> file reading -> 경로를 찾지 못해서 나는 오류
		
		

		//OutOfMemoryError -> 메모리 부족할때
		//memory leak(메모리 누수, 샌다, 부족하다) -> 로직을 바꿔야 함
		//반목문 제대로 종료하지 못하고 무한 루프 구성시
		
		
		
		
		
		
	}

}
