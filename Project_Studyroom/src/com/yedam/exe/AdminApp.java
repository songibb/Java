package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;
import com.yedam.seat.SeatService;


public class AdminApp {

	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	SeatService ss = new SeatService();
	
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
				memberMenu();
				break;
			case 2:
				seatMenu();
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
	private void memberMenu() {
		boolean flag = true;
		while(flag) {
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
				ms.deleteMember();
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
		
		
	}
	
	
	//회원 조회
	private void getMemberInfo() {
		boolean flag = true;
		while(flag) {
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
				flag = false;
				break;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
	}
	
	
	//회원 정보 수정
	private void updateMember() {
		boolean flag = true;
		while(flag) {
			System.out.println("------------------------------------------------------------");
			System.out.println("[회원 수정]");
			System.out.println("1. 비밀번호 | 2. 연락처 | 3. 연장 | 4. 좌석 | 5. 사물함 | 6. 뒤로 가기");
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
				ms.updateStartdate();
				
				break;
			case 4:
				ms.updateSeat();
				
				break;
			case 5:
				//ms.updateLocker();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
	}
	
	
	private void seatMenu() {
		boolean flag = true;
		while(flag) {
			System.out.println("------------------------------------------------------------");
			System.out.println("[좌석 관리]");
			System.out.println("1. 좌석 조회 | 2. 좌석 등록 | 3. 좌석 해지 | 4. 뒤로 가기");
			System.out.println("------------------------------------------------------------");
			System.out.println("입력>");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				getSeatInfo();
				break;
			case 2:
				ss.insertSeat();
				break;
			case 3:
				ss.deleteSeat();
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
	}
	
	private void getSeatInfo() {
		boolean flag = true;
		while(flag) {
			System.out.println("------------------------------------------------------------");
			System.out.println("[좌석 조회]");
			System.out.println("1. 전체 좌석 | 2. 미사용 좌석 | 3. 좌석 배치 현황 | 4. 뒤로 가기");
			System.out.println("------------------------------------------------------------");
			System.out.println("입력>");
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				ss.getSeatList();
				break;
			case 2:
				ss.getNoUseSeat();
				break;
			case 3:
				//좌석 배치 현황
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}
	}
	
}
