package com.yedam.homework0515;

public abstract class Culture {
	//필드
	String title;
	int directorNo;
	int actorNo;
	int audienceNo;
	int totalScore;
	
	//생성자
	Culture(String title, int directorNo, int actorNo){
		this.title = title;
		this.directorNo = directorNo;
		this.actorNo = actorNo;
	}
	
	//메소드
	
	

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public int getTotalScore() {
		return totalScore;
	}

	//public String getGrade()
	
	public abstract void getInformation();

	
	
	
	
}
