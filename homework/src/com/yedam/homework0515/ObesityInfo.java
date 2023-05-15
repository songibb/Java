package com.yedam.homework0515;

public class ObesityInfo extends StandardWeightInfo {

	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	@Override
	public void getInformation() {
		System.out.println(name + "님의 신장 " + height + ", 몸무게 " + weight + ", "+ getObesity() + " 입니다.");
		
	}
	public String getObesity() {
		double bmi = (weight - getStandardWeight())/getStandardWeight() * 100;
		if(bmi <= 18.5) {
			return "저체중";
		} else if(bmi <= 22.9) {
			return "정상";
		} else if(bmi <= 24.9) {
			return "과체중";
		} else {
			return "비만";
		}
	}
	
	
	
	
}
