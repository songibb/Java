package com.yedam.exe;

import java.util.Scanner;

import com.yedam.account.AccountService;
import com.yedam.member.MemberService;

public class MemberApp {  //고객

	Scanner sc = new Scanner(System.in);
	
	MemberService ms = new MemberService();
	AccountService as = new AccountService();
	
	public MemberApp() {
		memberRun();
	}
	
	private void memberRun() {
		boolean flag = true;
		while(flag) {
			menu();
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1":
				ms.getAccountInfo();
				break;
			case "2":
				as.inoutMoney();
				break;			
			case "3":
				as.transferMoney();
				break;
			case "4":
				flag = false; 
				MemberService.memberInfo = null;
				System.out.println("개인 업무 종료");			
				break;
				
			}
		}
		
	}
	
	
	 //고객 메뉴 -> 계좌조회, 입출금, 이체
	private void menu() {
		System.out.println("1. 계좌 조회 | 2. 입출금 | 3. 계좌 이체 | 4. 뒤로 가기");
	}
}
