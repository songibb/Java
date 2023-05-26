package com.yedam.locker;

import java.util.List;
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
	public void getLockerList() {
		System.out.println("[전체 사물함 조회]");
		List<Locker> list = LockerDAO.getInstance().getLockerList();
		
		for(Locker locker : list) {
			System.out.println("사물함 번호 : " + locker.getLockerNo());
			System.out.println("사물함 상태 : " + (locker.getLockerUse().equals("Y") ? "사용중" : "사용가능"));
			if(locker.getLockerUse().equals("Y")) {
				System.out.println("아이디 : " + locker.getMemberId());
				System.out.println("이름 : " + locker.getMemberName());
				System.out.println("사물함 등록일 :" + locker.getLockerStartdate() + ", 사물함 만료일 : " + locker.getLockerEnddate());
				System.out.println("좌석 등록일 : " + locker.getMemberStartdate() + ", 좌석 만료일 : " + locker.getMemberEnddate());
			}
			System.out.println("========================🧡 ");
		}
	}
	
	//미사용 사물함 조회
	public void getNoUseLocker() {
		System.out.println("[미사용 사물함 조회]");
		List<Locker> list = LockerDAO.getInstance().getNoUseLocker();
		if(list.size()!=0) {
			for(Locker locker : list) {
				System.out.println(locker.getLockerNo()+ " : " +(locker.getLockerUse().equals("Y") ? "사용중" : "사용가능") );
			}
		} else if(list.size()==0) {
			System.out.println("빈 사물함이 없습니다. 예약하시기 바랍니다.");
		}
	}
	
	
	//사물함 배치도
	public void nowLocker() {	
		System.out.println("[사물함 배치 현황]");
		System.out.println("사용중 : ■  사용가능 : □");
		List<Locker> list = LockerDAO.getInstance().getLockerList();	
		for(int i = 0; i<list.size();i++) {
			System.out.print(list.get(i).getLockerUse().equals("Y") ? list.get(i).getLockerNo()+" ■ \t" :  list.get(i).getLockerNo()+" □ \t");
			if((i+1) % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	
	
	//사물함 등록	
	public void insertLocker() {
		System.out.println("[사물함 등록]");		
		Locker locker = new Locker();
		int day = 0;
		
		System.out.println("아이디>");
		locker.setMemberId(sc.nextLine());
		while(true) {
			System.out.println("사물함 번호>");
			int lockerNo = Integer.parseInt(sc.nextLine());
			if(lockerNo > 10) {
				System.out.println("사물함이 존재하지 않습니다.");		
			} else {
				locker.setLockerNo(lockerNo);
				break;
			}
		}
		System.out.println("기간 선택> 1) 1일 | 2) 7일 | 3) 30일");
		day = Integer.parseInt(sc.nextLine());
		
		int result = LockerDAO.getInstance().insertLocker(locker, day);		
		if(result > 0) {
			System.out.println("사물함이 등록되었습니다.");
		}else {
			System.out.println("사물함이 등록되지 않았습니다.");
		}
	}
	
	//금일 만료 사물함 해지
	public void deleteEndLocker() {
		System.out.println("[만료 사물함 전체 해지]");
		List<Locker> list = LockerDAO.getInstance().endLockerList();
		Locker loc = new Locker();
		int result = 0;
		for(Locker locker : list) {
			loc.setMemberId(locker.getMemberId());
			result = LockerDAO.getInstance().deleteLocker(loc);
		}
		if(result > 0) {
			System.out.println("금일 기간만료 사물함이 전부 해지되었습니다.");
		}else {
			System.out.println("금일 기간만료 사물함이 해지되지 않았습니다.");
		}
	}
	
	
	//사물함 해지
	public void deleteLocker() {
		System.out.println("[사물함 해지]");
		Locker locker = new Locker();
		
		System.out.println("아이디>");
		locker.setMemberId(sc.nextLine());
		
		int result = LockerDAO.getInstance().deleteLocker(locker);
		if(result > 0) {
			System.out.println("사물함이 해지되었습니다.");
		}else {
			System.out.println("사물함이 해지되지 않았습니다.");
		}
	}
	
}
