package com.yedam.API;

public class SmartPhone {
	private String company;
	private int price;
	private String name;
	
	
	public SmartPhone(String company, int price, String name) {
		this.company = company;
		this.price = price;
		this.name = name;
	}


//	@Override
//	public String toString() {
//		return company + ", " +price + ", " + name;
//	}
		
	@Override
	//toString 자동완성기능 이용
	public String toString() {
		return "SmartPhone [company=" + company + ", price=" + price + ", name=" + name + "]";
	}
	
}
