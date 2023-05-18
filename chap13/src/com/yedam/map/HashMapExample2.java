package com.yedam.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
//		map.put(new Student(1, "김또치"), 85);
//		map.put(new Student(1, "김또치"), 90);
		
		map.put(new Student(1, "김또치"), 85);
		map.put(new Student(1, "고길동"), 90);   //sno만 같아도 같은 객체로 보게 함

		
		System.out.println("총 Entry 수 : " + map.size());
	}

}
