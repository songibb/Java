package com.yedam.homework0515;

public class Performance extends Culture{
	
	String genre;
	
	Performance(String title, int directorNo, int actorNo) {
		super(title, directorNo, actorNo);
		
	}

	@Override
	public void getInformation() {
		System.out.println("공연제목 : " + title);
		System.out.println("감독 : " + directorNo);
		System.out.println("배우 : " + actorNo);
		System.out.println("공연총점 : " + totalScore);
		System.out.println("공연평점 : " + getGrade());
	}
}
