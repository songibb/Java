package com.yedam.homework0515;

public class ObesityInfo extends StandardWeightInfo {

	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	public void getInformation() {
		System.out.println(name + "님의 신장 " + height + ", 몸무게 " + weight + ", 비만도 " + getObesity() + " 입니다.");
		
	}
	public double getObesity() {
		return (weight - getStandardWeight())/getStandardWeight() * 100;
	}
	

//	if(getObesity() <= 18.5) {
//		return "저체중";
//	}
	
}
