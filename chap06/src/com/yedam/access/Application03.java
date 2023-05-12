package com.yedam.access;

public class Application03 {

	public static void main(String[] args) {
		//하나의 객체를 외부로 전달
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);  //같은 주소값 -> 하나의 객체
		
		
		s1.age = 100;
		s1.name = "고길동";
		
		System.out.println(s2.age);
		System.out.println(s2.name);  //s2에는 데이터를 넣지 않았지만 s2에서도 데이터 출력
		
		
		
		Member member = new Member();
		member.instance();
		
	}

}
