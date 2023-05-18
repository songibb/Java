package com.yedam.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servelt/JSP");
		set.add("Java");  //중복 데이터 -> 저장 안됨
		set.add("iBatis");
		
		//size
		int size = set.size();
		System.out.println("총 객체 수 : " + size);
		
		//반복자를 활용한 HashSet 객체 출력
		Iterator<String> iterator = set.iterator();   //set은 순서가 없기 때문에 iterator로 순서를 정렬해서 하나씩 꺼내옴
		
		//iterator.hasNext() -> 다음에 가져올 데이터가 있는지 확인
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("Java");
		set.remove("JDBC");
		
		System.out.println("====향상된 for문====");
		
		for(String temp : set) {
			System.out.println("\t" + temp);
		}
		
		set.clear();
		
		System.out.println("총 객체 수 : " + set.size());
		
		if(set.isEmpty()) {
			System.out.println("객체가 하나도 없습니다.");
		}
		
		
		
		Set<Member> mSet = new HashSet<>();
		
		mSet.add(new Member("고길동", 26));
		mSet.add(new Member("고길동", 26));
		
		System.out.println("총 객체 수: " + mSet.size());  //hashcode와 equals를 수정 -> 총 객체수 1 ->같은 객체로 봄
		
		
		
		
		
		
		
		

	}

}
