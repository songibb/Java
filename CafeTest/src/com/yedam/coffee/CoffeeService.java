package com.yedam.coffee;

import java.util.List;
import java.util.Scanner;


public class CoffeeService {

	Scanner sc = new Scanner(System.in);
	//메뉴조회
	public void getCoffeeList() {
		List<Coffee> list = CoffeeDAO.getInstance().getCoffeeList();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("메뉴 : " + list.get(i).getCoffeeMenu() + " 가격 : " + list.get(i).getCoffeePrice());
		}
		//향상된 for문
//		for(Coffee coffee : list) {
//			System.out.println("메뉴 : " + coffee.getCoffeeMenu() + " 가격 : " + coffee.getCoffeePrice());
//		}
		
	}
	
	//상세조회
	public void getCoffeeMenu() {
		System.out.println("메뉴 입력>");
		String menuName = sc.nextLine();
		
		Coffee coffee = CoffeeDAO.getInstance().getCoffeeMenu(menuName);
		
		if(coffee == null) {
			System.out.println("없는 메뉴 입니다.");
		} else {
			System.out.println("메뉴 : " + coffee.getCoffeeMenu() + " 가격 : " + coffee.getCoffeePrice() + " 설명 : " + coffee.getCoffeeExplain());
		}
		
	}
	
	
	//메뉴 등록
	public void insertCoffee() {
		Coffee coffee = new Coffee();
		
		System.out.println("메뉴 입력>");
		coffee.setCoffeeMenu(sc.nextLine());		
		System.out.println("가격 입력>");
		coffee.setCoffeePrice(Integer.parseInt(sc.nextLine()));
		System.out.println("설명 입력>");
		coffee.setCoffeeExplain(sc.nextLine());
		
		int result = CoffeeDAO.getInstance().insertCoffee(coffee);
		
		if(result > 0) {
			System.out.println("메뉴 등록 완료");
		}else {
			System.out.println("메뉴 등록 실패");
		}
		
				
	}
	
	//판매
	public void sellCoffee() {
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		
		int result = CoffeeDAO.getInstance().sellCoffee(menu);
		
		if(result >= 1) {
			System.out.println("판매 완료");
		} else{
			System.out.println("판매 실패");
		}
		
	}
	
	//메뉴 삭제
	public void deleteCoffee() {
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		
		int result = CoffeeDAO.getInstance().deleteCoffee(menu);
		
		if(result != 0) {
			System.out.println("메뉴 삭제 완료");
		} else {
			System.out.println("메뉴 삭제 실패");
		}
	}
	
	
	//매출 
	public void salesCoffeeList() {
		List<Coffee> list = CoffeeDAO.getInstance().salesCoffeeList();
		int total = 0;
		for(int i = 0; i<list.size(); i++) {
			System.out.println("메뉴 : " + list.get(i).getCoffeeMenu() + ", 판매갯수 : "
						+ list.get(i).getCoffeeSales() + "개, 판매금액 : " 
						+ list.get(i).getCoffeeSales()*list.get(i).getCoffeePrice()+"원");				
			total += list.get(i).getCoffeeSales()*list.get(i).getCoffeePrice();
		}
		System.out.println("총 판매금액 : " + total);

	}
	

}
