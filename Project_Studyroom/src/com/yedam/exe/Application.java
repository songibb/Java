package com.yedam.exe;

import java.util.Scanner;

import com.yedam.locker.LockerService;
import com.yedam.member.MemberService;
import com.yedam.seat.SeatService;




public class Application {

	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	SeatService ss = new SeatService();
	LockerService ls = new LockerService();
	
	public Application() {
		start();
	}
	
	boolean run = true;	
	
	private void start() {	
		
		while(run) {
			if(MemberService.memberInfo == null) {
				startMenu();
			}else if(MemberService.memberInfo != null) {
				if(MemberService.memberInfo.getMemberAuth().equals("N")) {
					//사용자
					new MemberApp();
				}else if(MemberService.memberInfo.getMemberAuth().equals("A")) {
					//관리자
					new AdminApp();
				}
			}
		}	
	}
		
	private void startMenu() {	
		System.out.println("-------------------------------------------------------------------");
		System.out.println("[독서실에 오신 것을 환영합니다 ╰(*°▽°*)╯]");
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료 | 4. 책상과 의자 놓기 | 5. 사물함 놓기");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("입력>");
		int menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			ms.login();
		}else if(menu == 2){
			authSelect();
		}else if(menu == 3) {
			run = false;
			System.out.println("프로그램 종료");
		}else if(menu == 4) {
			ss.seatSetting();
		}else if(menu == 5) {
			ls.lockerSetting();
		}else{
			System.out.println("메뉴를 잘못 입력하였습니다.");
		}				
	}
	
	
	//권한별 회원가입
	private void authSelect() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("[회원 가입]");
		System.out.println("1. 일반 사용자 | 2. 관리자 | 3. 뒤로 가기");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("입력>");
		int menu = Integer.parseInt(sc.nextLine());
		if(menu == 1) {
			ms.insertNormal();
		}else if(menu == 2) {
			ms.insertAdmin();
		}else if(menu == 3) {
			startMenu();
		}else{
			System.out.println("메뉴를 잘못 입력하였습니다.");
		}	
	}
	
	
	
	
	
	
}
