package com.yedam.homework0515;

public class Application {
	public static void main(String[] args) {
		
		//Q1
		EmpDept ed = new EmpDept("이지나", 3000, "교육부");
		
		ed.getInformation();
		ed.print();
		
		
		//Q2	
		StandardWeightInfo swi =  new StandardWeightInfo("홍길동", 168, 45);
		swi.getInformation();
		
		ObesityInfo oi = new ObesityInfo("박둘이", 168, 90);
		oi.getInformation();

		
		//Q3
		Movie movie = new Movie("추격자", 7, 5);
		movie.setTotalScore(4);
		movie.getInformation();
		
		System.out.println("=====================");
		
		Performance perform = new Performance("지킬앤하이드", 9, 10);
		perform.setTotalScore(5);
		perform.getInformation();
		
		
	}
	
	
	
}
