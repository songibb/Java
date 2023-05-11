package com.yedam.homework;

import java.util.Scanner;

public class homework_0511 {

	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품명과 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		//	출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		//상품 정보를 담는 배열
		Product[] proArr = null;
		
		//상품 수를 담는 변수
		int proNum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("====================================================");
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료 ");
			System.out.println("====================================================");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo == 1) {
				
				System.out.println("상품 수>");
				proNum = Integer.parseInt(sc.nextLine());	
				
			} else if(selectNo == 2) {
				proArr = new Product[proNum];
				
				for(int i = 0; i<proNum; i++) {
					System.out.println("상품명>");
					proArr[i].proName = sc.nextLine();
					
					System.out.println("가격>");
					proArr[i].proPrice = sc.nextLine();
				}
				
			} else if(selectNo == 3) {
				
				
			} else if(selectNo == 4) {
				
			} else if(selectNo == 5) {
				
			}
			
			
		}
		

	}

}
