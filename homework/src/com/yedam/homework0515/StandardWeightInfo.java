package com.yedam.homework0515;

public class StandardWeightInfo extends Human{

	StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	public void getInformation() {
		System.out.println(name + "님의 신장 " + height + ", 몸무게 " + weight + ", 표준체중 " + getStandardWeight() + " 입니다.");
	}
	
	public double getStandardWeight() {
		return (height-100)*0.9;
	}
	

}
