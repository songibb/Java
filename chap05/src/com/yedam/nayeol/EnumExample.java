package com.yedam.nayeol;

import java.util.Calendar;

public class EnumExample {

	public static void main(String[] args) {
	  // 타입   변수  = 데이터
		Week today = null;   
		//today에는 Week가 가지고 있는 데이터만 사용 가능
		//today가 가질 수 있는 데이터는 Week.java에 저장된 MONDAY ~ SUNDAY

		
		//오늘이 무슨 요일인지 숫자로 알려줌 (일요일 = 1, 월요일 = 2,.... 토요일 = 7)
		Calendar cal = Calendar.getInstance();
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		
		System.out.println("오늘의 요일 : " + today);
		
		
	}

}
