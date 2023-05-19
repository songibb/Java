package com.yedam.store;

import java.util.List;
import java.util.Scanner;


public class StoreService {
	Scanner sc = new Scanner(System.in);

	//모든 가게 정보 조회
	public void getStoreList() {
		List<Store> list = StoreDAO.getInstance().getStoreList();
		
		System.out.println("- 가게 정보 조회 -");
		
		for(Store store : list) {
			System.out.println("===================================");
			System.out.println("가게번호 : " + store.getStoreId());
			System.out.println("가게명 : " + store.getStoreName());
			System.out.println("가게연락처 : " + store.getStoreTel());
			System.out.println("주소 : " + store.getStoreAddr());
			System.out.println("매출 : " + store.getStoreSales());
		}
	}
	//지역구별 매출 합계 조회
	public void getStoreSales() {
		List<Store> list = StoreDAO.getInstance().getStoreSales();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("===================================");
			System.out.println("지역구 : " + list.get(i).getStoreAddr());
			System.out.println("매출합계 : " + list.get(i).getStoreSales());
		}
	}
	
	
	//가게 정보 입력
	public void insertStore() {
		Store store = new Store();
		System.out.println("- 가게 등록 -");
		System.out.println("==================================="); //서브쿼리를 활용해서 id 값을 자동부여해서 id값은 입력받을 필요 없음
		System.out.println("상호명>");
		store.setStoreName(sc.nextLine());
		System.out.println("연락처>");
		store.setStoreTel(sc.nextLine());
		System.out.println("주소>");
		store.setStoreAddr(sc.nextLine());
		System.out.println("매출>");
		store.setStoreSales(Integer.parseInt(sc.nextLine()));
		
		int result = StoreDAO.getInstance().insertStore(store);
		
		if(result>0) {
			System.out.println("가게 정보 입력 완료");
		}else {
			System.out.println("가게 정보 입력 실패");
		}
	}
	
	
	//매출 수정
	public void updateSales() {
		System.out.println("- 매출 수정 -");
		
		Store store = new Store();
		
		System.out.println("ID>");
		store.setStoreId(Integer.parseInt(sc.nextLine()));
	
		System.out.println("매출>");
		store.setStoreSales(Integer.parseInt(sc.nextLine()));
		
		int result = StoreDAO.getInstance().updateSales(store);
		
		if(result>0) {
			System.out.println("매출 수정 완료");
		} else {
			System.out.println("연락처 수정 실패");
		}

	}
	
	
	
}
