package com.yedam.exe;

import java.util.Scanner;

import com.yedam.admin.AdminService;
import com.yedam.member.MemberService;


public class AdminApp {

	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	public AdminApp() {
		adminMenu();
		
	}
	
	private void adminMenu() {
		boolean flag = true;
		while(flag) {
			System.out.println("------------------------------------------------------------");
			System.out.println("[관리자 메뉴]");
			System.out.println("1. 회원 관리 | 2. 좌석 관리 | 3. 사물함 관리 | 4. 예약 현황 | 5. 로그아웃");
			System.out.println("------------------------------------------------------------");
			System.out.println("입력>");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				memberManage();
				break;
			case 2:
				//좌석 관리
				break;
			case 3:
				//사물함 관리
				break;
			case 4:
				//예약 현황
				break;
			case 5:
				flag = false;
				MemberService.memberInfo = null;
				System.out.println("로그아웃 완료되었습니다.");		
				break;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
		
	}
	
	
	
	//회원 관리
	private void memberManage() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[회원 관리]");
		System.out.println("1. 회원 조회 | 2. 회원 수정 | 3. 회원 삭제 | 4. 뒤로 가기");
		System.out.println("------------------------------------------------------------");
		System.out.println("입력>");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1:
			getMemberInfo();
			break;
		case 2:
			updateMember();
			break;
		case 3:
			//ms.deleteMember();
			break;
		case 4:
			adminMenu();
			break;
		default:
			System.out.println("메뉴를 잘못 입력하였습니다.");
		}
		
	}
	
	
	//회원 조회
	private void getMemberInfo() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[회원 조회]");
		System.out.println("1. 전체 회원 | 2. 개별 회원 | 3. 금일 만료 회원 | 4. 뒤로 가기");
		System.out.println("------------------------------------------------------------");
		System.out.println("입력>");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1:
			ms.getMemberList();
			break;
		case 2:
			ms.getMember();
			break;
		case 3:
			ms.endMemberList();
			break;
		case 4:
			adminMenu();
			break;
		default:
			System.out.println("메뉴를 잘못 입력하였습니다.");
		}
		
	}
	
	
	//회원 정보 수정
	private void updateMember() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[회원 수정]");
		System.out.println("1. 비밀번호 | 2. 연락처 | 3. 좌석 | 4. 사물함 | 5. 등록일 | 6. 뒤로 가기");
		System.out.println("------------------------------------------------------------");
		System.out.println("입력>");
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
		case 1:
			ms.updatePW();
			break;
		case 2:
			ms.updateTel();
			break;
		case 3:
			ms.updateSeat();
			break;
		case 4:
			ms.updateLocker();
			break;
		case 5:
			ms.updateStartdate();
			break;
		case 6:
			memberManage();
			break;
		}
	}
	
	
}
