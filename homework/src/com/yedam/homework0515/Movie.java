package com.yedam.homework0515;

public class Movie extends Culture {
	
	String genre;
	
	Movie(String title, int directorNo, int actorNo) {
		super(title, directorNo, actorNo);
		
	}

	@Override
	public void getInformation() {
		System.out.println("영화제목 : " + title);
		System.out.println("감독 : " + directorNo);
		System.out.println("배우 : " + actorNo);
		System.out.println("영화총점 : " + totalScore);
		System.out.println("영화평점 : " + getGrade());
	}


}
