package com.yedam.access;

public class Application01 {

	public static void main(String[] args) {
		Access ac = new Access();
		ac.free = "public";
		ac.parent = "protected";
		ac.basic = "default";
		//ac.privacy = "private"; -> 오류   
		ac.instead();

	}

}
