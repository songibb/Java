package com.yedam.oop;

import java.util.Scanner;

import com.yedam.access.Access;

public class Application07 {

	public static void main(String[] args) {
		//클래스에 정의된 정적 멤버 사용  -> 어디에서든 공유 가능
		//클래스명.필드명 | 클래스명.메소드명
		System.out.println(StaticCal.PI);
		
		System.out.println(StaticCal.minus(10, 5));
		System.out.println(StaticCal.plus(10, 5));
		
		
		
		Person p1 = new Person("111111-1111111", "김또치");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//p1.ssn = "222222-2222222";   ->final필드 데이터 저장되면 변경이 불가
		//p1.nation = "미국";   ->final필드 데이터 저장되면 변경이 불가
		
		System.out.println("지구의 반지름 : " + StaticCal.EARTH_RADIUS);
		System.out.println("지구의 표면적 : " + StaticCal.PI * StaticCal.EARTH_RADIUS * StaticCal.EARTH_RADIUS);

		
		//import 단축키 -> ctrl+shift+o -> import할 게 하나만 있는 경우 창이 안뜸
		Scanner sc = new Scanner(System.in);
		
		
		Access ac = new Access();  //import
		ac.free = "public";
		//ac.parent = "protected"; -> 다른 패키지라서 오류  -> 상속관계가 만들어지면 부모가 가진 필드 사용 가능
		//ac.basic = "default";    -> 다른 패키지라서 오류 
		//ac.privacy = "private";  -> 다른 패키지라서 오류
		
	}

}
