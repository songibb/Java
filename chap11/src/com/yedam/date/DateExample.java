package com.yedam.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		
		System.out.println(sdf.format(date));
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;   //0~11 -> +1 해줘야함
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		int week = now.get(Calendar.DAY_OF_WEEK);  //1~7 -> 일~토
		String strWeek = "";
		switch(week) {
		case 1:
			strWeek = "일";
			break;
		case Calendar.MONDAY:   // 숫자를 써도 되고 Calendar.상수 로 써도 됨
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case 4:
			strWeek = "수";
			break;
		case 5:
			strWeek = "목";
			break;
		case 6:
			strWeek = "금";
			break;
		case 7:
			strWeek = "토";
			break;
		}
		
		int amPm = now.get(Calendar.AM_PM);  //0:오전, 1:오후
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.print(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.print(second + "초");
		
		
		
		
		
		
	}
}
