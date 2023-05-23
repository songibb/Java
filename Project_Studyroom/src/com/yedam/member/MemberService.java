package com.yedam.member;

import java.sql.Date;
import java.util.Scanner;

public class MemberService {
	
	public static Member memberInfo = null;
	
	Scanner sc = new Scanner(System.in);
	
	//로그인
	public void login() {
		Member member = null;
		System.out.println("아이디>");
		String id = sc.nextLine();
		
		System.out.println("비밀번호>");
		String pw = sc.nextLine();
		
		member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println(member.getMemberId()+ "님 환영합니다.");
				memberInfo = member;
			} else {
				System.out.println("비밀번호가 틀립니다.");
			}
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}
	
	//회원가입
	Member mem = new Member();
	int day = 0;
	
	public void insertNormal() {
		insertMember();
		System.out.println("기간 선택> 1) 1일 | 2) 7일 | 3) 30일");
		day = Integer.parseInt(sc.nextLine());
		
		int result = MemberDAO.getInstance().insertNormal(mem, day);
		
		if(result>0) {
			System.out.println("회원가입을 성공하였습니다.");
		} else {
			System.out.println("회원가입을 실패하였습니다.");
		}
	}
	
	public void insertAdmin() {
		insertMember();
		int result = MemberDAO.getInstance().insertAdmin(mem);
	
		if(result>0) {
			System.out.println("회원가입을 성공하였습니다.");
		} else {
			System.out.println("회원가입을 실패하였습니다.");
		}
	}
	
	public void insertMember() {
		System.out.println("[회원가입]");
		String id = "";
		while(true) {
			System.out.println("아이디>");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member != null) { 
				System.out.println("이미 사용중인 아이디입니다.");
			} else if(member == null) {
				System.out.println("사용가능한 아이디입니다.");
				break;
			}
		}
		System.out.println("비밀번호>");
		String pw = sc.nextLine();
		System.out.println("이름>");
		String name = sc.nextLine();
		System.out.println("연락처>");
		String tel = sc.nextLine();

		mem.setMemberId(id);
		mem.setMemberPw(pw);
		mem.setMemberName(name);
		mem.setMemberTel(tel);

	}
	
	
	//내 정보 조회
	public void getInfo() {
		System.out.println("[내 정보]");
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("아이디 : " + member.getMemberId());
		System.out.println("비밀번호 : " + member.getMemberPw());
		System.out.println("이름 : " + member.getMemberName());
		System.out.println("연락처 : " + member.getMemberTel());
		System.out.println("등록일 : " + member.getMemberStartdate());
		System.out.println("만료일 : " + member.getMemberEnddate());
		
		//좌석
		//사물함

	}
	
	//전체 회원 조회
	public void getMemberList() {
		
	}	
	
	//개별 회원 조회
	public void getMember() {
		
	}
		
	//금일 만료 회원 조회
	public void endMemberList() {
		
	}
	//회원 정보 수정
	Member member = new Member();
	int num = 0;
	
	public void updatePW() {	
		update1();	
		num = 1;
		System.out.println("수정 비밀번호>");
		String pw = sc.nextLine();	
		member.setMemberPw(pw);		
		update2();
	}	
	public void updateTel() {
		update1();
		num = 2;
		System.out.println("수정 연락처>");
		String tel = sc.nextLine();	
		member.setMemberTel(tel);		
		update2();
	}	
	public void updateSeat() {
		
	}
	public void updateLocker() {
		
	}
	public void updateStartdate() {
		update1();
		num = 5;
		System.out.println("수정 등록일>");
		

		java.sql.Date date = java.sql.Date.valueOf(sc.nextLine());
		member.setMemberStartdate(date);

//		System.out.println("기간 선택> 1) 1일 | 2) 7일 | 3) 30일");
//		day = Integer.parseInt(sc.nextLine());	
		update2();
	}
	public void update1() {
		System.out.println("아이디>");
		String id = sc.nextLine();
		member.setMemberId(id);
	}
	
	public void update2() {
		int result = MemberDAO.getInstance().updateMember(member, num, day);		
		if(result>0) {
			System.out.println("회원 정보를 수정하였습니다.");
		} else {
			System.out.println("회원 정보를 수정하지 못했습니다.");
		}
	}
	
	
	


	
	
}
