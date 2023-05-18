package com.yedam.homework0515;

public abstract class Culture {
	//필드
	String title;
	int directorNo;
	int actorNo;
	int audienceNo=0;
	int totalScore;
	
	
	//생성자
	Culture(String title, int directorNo, int actorNo){
		this.title = title;
		this.directorNo = directorNo;
		this.actorNo = actorNo;
	}
	
	//메소드
	public void setTotalScore(int score) {
		totalScore += score;
		audienceNo++;
	}
	

	public String getGrade() {
		String star = "";
		for(int i=0; i<totalScore/audienceNo; i++) {
			star += "☆";
		}
		return star;
		
	}
	
	public abstract void getInformation();

	
	
	
	
}
