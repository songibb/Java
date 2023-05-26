package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class MemberApp {
		
	Scanner sc = new Scanner(System.in);
	
	MemberService ms = new MemberService();
	
	public MemberApp() {
		memberMenu();
	}
	
	private void memberMenu() {
		boolean flag = true;
		while(flag) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("[사용자 메뉴]");
			System.out.println("1. 내 정보 조회 | 2. 로그아웃");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("입력>");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				ms.getInfo();
			} else if(menu == 2) {
				flag = false; 
				MemberService.memberInfo = null;
				System.out.println("로그아웃 완료되었습니다.");			
			} else {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}	
	}
	
	
	
}
