package com.yedam.exe;

import java.util.Scanner;

import com.yedam.coffee.CoffeeService;

public class Application {

	Scanner sc = new Scanner(System.in);
	CoffeeService cs = new CoffeeService();
	
	public Application() {
		run();
	}
	
	private void run() {
		
		boolean flag = true;
		while(flag) {
			System.out.println("메뉴 입력>");
			String no = sc.nextLine();
			 menu();		 
			 switch(no) {
			 case "1":
				 cs.getCoffeeList();
				 break;
			 case "2":
				 cs.getCoffeeMenu();
				 break;
			 case "3":
				 cs.insertCoffee();
				 break;
			 case "4":
				 cs.sellCoffee();
				 break;
			 case "5":
				 cs.deleteCoffee();
				 break;
			 case "6":
				 cs.salesCoffeeList();
				 break;
			 case "7":
				 System.out.println("end of prog");
				 break;	 
			 }
		 }
	}

	private void menu() {
		System.out.println("1. 메뉴 조회 | 2. 메뉴 상세 조회 | 3. 메뉴 등록 | 4. 판매 | 5. 메뉴 삭제 | 6. 매출 | 7. 종료");
		
	}
}
