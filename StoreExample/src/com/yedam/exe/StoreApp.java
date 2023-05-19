package com.yedam.exe;

import java.util.Scanner;

import com.yedam.store.StoreService;


public class StoreApp {
	
	Scanner sc = new Scanner(System.in);
	StoreService ss = new StoreService();
	
	boolean run = true;
	private String menu = null;
	
	public StoreApp() {
		start();
	}
	
	private void start() {
		
		while(run) {
			menu();
			
			switch(menu) {
			case "1":
				ss.getStoreList();
				break;
			case "2":
				ss.getStoreSales();
				break;
			case "3":
				ss.insertStore();
				break;
			case "4":
				ss.updateSales();
				break;
			case "5":
				run = false;
				System.out.println("프로그램 종료");
				break;
			}
		}

		
	}
	
	private void menu() {
		System.out.println("1. 모든 가게 정보 조회 | 2. 지역구별 매출 합계 조회 | 3. 가게 정보 입력 | 4. 매출 수정 | 5. 종료");
		System.out.println("입력>");
		menu = sc.nextLine();
	}
	
	
	
}
