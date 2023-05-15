package com.yedam.homework0515;

public class Application {
	public static void main(String[] args) {
		
		//Q1
		EmpDept ed = new EmpDept("이지나", 3000, "교육부");
		
		ed.getInformation();
		ed.print();
		
		
		//Q2	
		
		StandardWeightInfo swi = (StandardWeightInfo) new Human("홍길동", 168, 45);
		swi.getInformation();
		
		ObesityInfo oi = new ObesityInfo("박둘이", 168, 90);
		oi.getInformation();


		
		
	}
	
	
	
}
