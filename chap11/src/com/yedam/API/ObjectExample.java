package com.yedam.API;

import java.util.HashMap;

public class ObjectExample {

	public static void main(String[] args) {
		Member member = new Member("123");
		Member member2 = new Member("123");
		Member member3 = new Member("321");

		
		if(member.equals(member2)) {
			System.out.println("동등한 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		if(member.equals(member3)) {
			System.out.println("동등한 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		
		///hashcode => 필드의 정보 ex)String -> hashcode는 객체가 갖는 것
		//기본타입은 객체가 아니어서 hashcode 비교 필요없음
		
		HashMap<Key, String> hashMap = new HashMap<>();
		hashMap.put(new Key(1), "홍길동");
		String value = hashMap.get(new Key(1));  
		System.out.println(value);
		
		HashMap<Member, String> hashMap01 = new HashMap<>();		
		hashMap01.put(new Member("123"), "길동");   		
		System.out.println(hashMap01.get(new Member("123")));  
		
		
		
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj);   //toString()이 생략되어있음
		System.out.println(obj.toString());
		
		
		
		
		SmartPhone sp = new SmartPhone("apple", 100, "iphone");	
		System.out.println(sp.toString());
		
		
		
		
		
	}

}
