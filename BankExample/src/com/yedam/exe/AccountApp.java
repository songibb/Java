package com.yedam.exe;

import java.util.Scanner;

import com.yedam.account.AccountService;
import com.yedam.member.MemberService;

public class AccountApp {  //은행원
	AccountService as = new AccountService();
	Scanner sc = new Scanner(System.in);
	
	public AccountApp() {
		run();
	}
	
	private void run() {
		while(true) {
			menu();
			String menuNo = sc.nextLine();
			if(menuNo.equals("1")) {
				//고객 등록
				as.insertMember();
			} else if(menuNo.equals("2")) {	
				//계좌 개설
				as.inserAccount();
			} else if(menuNo.equals("3")) {
				//입출금 -> 입금, 출금 -> DAO 메소드는 1개
				as.inoutMoney();
			} else if(menuNo.equals("4")) {
				//계좌 이체
				as.transferMoney();
			} else if(menuNo.equals("5")) {
				//계좌 해지
				as.deleteAccount();
			} else if(menuNo.equals("6")) {
				//뒤로 가기
				//은행원 업무가 끝나서 로그인 하는 곳으로 이동
				System.out.println("은행원 업무 종료");
				MemberService.memberInfo = null;
				break;
			}
					
		}
	}
	
	private void menu() {
		System.out.println("1. 고객 등록 | 2. 계좌 개설 | 3. 입출금 | 4. 계좌 이체 | 5. 계좌 해지 | 6. 뒤로 가기");
		
	}
}
