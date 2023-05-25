package com.yedam.locker;

import java.util.Scanner;

public class LockerService {
	
	Scanner sc = new Scanner(System.in);
	
	
	//locker테이블에 자리 만들기
	public void lockerSetting() {
		System.out.println("[사물함을 놓고 있습니다.]");
		int result = LockerDAO.getInstance().lockerSetting();		
		if(result > 0) {
			System.out.println("셋팅 완료");
		}else {
			System.out.println("셋팅 실패");
		}
	}
	//전체 사물함 조회
	
	//미사용 사물함 조회
	
	//사물함 등록	
	public void insertLocker() {
		System.out.println("[사물함 등록]");		
		Locker locker = new Locker();
		int day = 0;
		
		System.out.println("아이디>");
		locker.setMemberId(sc.nextLine());
		System.out.println("사물함 번호>");
		locker.setLockerNo(Integer.parseInt(sc.nextLine()));
		System.out.println("기간 선택> 1) 1일 | 2) 7일 | 3) 30일");
		day = Integer.parseInt(sc.nextLine());
		
		int result = LockerDAO.getInstance().insertLocker(locker, day);		
		if(result > 0) {
			System.out.println("사물함이 등록되었습니다.");
		}else {
			System.out.println("사물함이 등록되지 않았습니다.");
		}
	}
	
	
	//사물함 해지
	public void deleteLocker() {
		System.out.println("[사물함 해지]");
		Locker locker = new Locker();
		
		System.out.println("아이디>");
		locker.setMemberId(sc.nextLine());
		System.out.println("사물함 번호>");
		locker.setLockerNo(Integer.parseInt(sc.nextLine()));
		
		int result = LockerDAO.getInstance().deleteLocker(locker);
		if(result > 0) {
			System.out.println("사물함이 해지되었습니다.");
		}else {
			System.out.println("사물함이 해지되지 않았습니다.");
		}
	}
	
}
