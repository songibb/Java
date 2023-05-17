package com.yedam.API;

public class MathExample {

	public static void main(String[] args) {
		//절대값
		int v1 = Math.abs(-1);
		System.out.println(v1);
		double v2 = Math.abs(-3.1);
		System.out.println(v2);
		
		//올림
		double v3 = Math.ceil(5.3);
		System.out.println(v3);
		double v4 = Math.ceil(-5.3);
		System.out.println(v4);
		
		//버림
		double v5 = Math.floor(5.3);
		System.out.println(v5);
		double v6 = Math.floor(-5.3);
		System.out.println(v6);
		
		//최대값
		int v7 = Math.max(5, 9);
		System.out.println(v7);
		//최소값
		int v8 = Math.min(5, 9);
		System.out.println(v8);
		
		//랜덤
		double v9 = Math.random();
		System.out.println(v9);
		
		//rint
		double v10 = Math.rint(8.5);  //짝수.  -> 버림
		System.out.println(v10);
		double v11 = Math.rint(7.5);  //홀수.  -> 올림
		System.out.println(v11);
		double v12 = Math.rint(3.5);  
		System.out.println(v12);
		
		//반올림
		double v13 = Math.round(5.3);
		System.out.println(v13);
		
		
		
	}

}
