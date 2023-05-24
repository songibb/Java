package com.yedam.member;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.seat.Seat;

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
				System.out.println(member.getMemberName()+ "님 환영합니다.");
				memberInfo = member;
			} else {
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
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
		System.out.println("[회원가입에 필요한 정보를 입력해주세요.]");
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
		System.out.println("========================");
		//좌석
		System.out.println("좌석번호 : " + member.getSeatNo());
		System.out.println("등록일 : " + member.getMemberStartdate());
		System.out.println("만료일 : " + member.getMemberEnddate());
		System.out.println("========================");
		//사물함
		//System.out.println("사물함번호 : " + member.getLockerNo());
		//System.out.println("등록일 : " + member.getLockerStartdate());
		//System.out.println("만료일 : " + member.getLockerEnddate());
		System.out.println("========================");

	}
	
	
	//전체 회원 조회
	public void getMemberList() {
		System.out.println("[전체 회원 조회]");
		List<Member> list = MemberDAO.getInstance().getMemberList();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("회원번호 : " + list.get(i).getMemberNo());
			System.out.println("아이디 : " + list.get(i).getMemberId());
			System.out.println("비밀번호 : " + list.get(i).getMemberPw());
			System.out.println("이름 : " + list.get(i).getMemberName());
			System.out.println("연락처 : " + list.get(i).getMemberTel());
			System.out.println("등록일 : " + list.get(i).getMemberStartdate());
			System.out.println("만료일 : " + list.get(i).getMemberEnddate());
			System.out.println("권한 : " + (list.get(i).getMemberAuth().equals("N") ? "일반사용자" : "관리자"));
			System.out.println("========================🧡 ");
		}
		
	}	
	
	//개별 회원 조회
	public void getMember() {
		System.out.println("[개별 회원 조회]");
		System.out.println("조회 아이디>");
		String id = sc.nextLine();
		
		Member member = MemberDAO.getInstance().getMember(id);
		
		if(member == null) {
			System.out.println("조회하신 회원이 존재하지 않습니다.");
		} else {
			System.out.println("회원번호 : " + member.getMemberNo());
			System.out.println("아이디 : " + member.getMemberId());
			System.out.println("비밀번호 : " + member.getMemberPw());
			System.out.println("이름 : " + member.getMemberName());
			System.out.println("연락처 : " + member.getMemberTel());
			System.out.println("등록일 : " + member.getMemberStartdate());
			System.out.println("만료일 : " + member.getMemberEnddate());
			System.out.println("권한 : " + (member.getMemberAuth().equals("N") ? "일반사용자" : "관리자"));
			
		}
	}
		
	//금일 만료 회원 조회
	public void endMemberList() {
		System.out.println("[금일 만료 회원 조회]");
		List<Member> list = MemberDAO.getInstance().endMemberList();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("회원번호 : " + list.get(i).getMemberNo());
			System.out.println("아이디 : " + list.get(i).getMemberId());
			System.out.println("비밀번호 : " + list.get(i).getMemberPw());
			System.out.println("이름 : " + list.get(i).getMemberName());
			System.out.println("연락처 : " + list.get(i).getMemberTel());
			System.out.println("========================🧡 ");
		}
	}
	
	
	
	//회원 정보 수정
	Member member = new Member();
	Seat seat = new Seat();
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
		String tel = "";
		while(true) {
			System.out.println("수정 연락처>");
			tel = sc.nextLine();
			if(tel.length() > 13) {
				System.out.println("올바른 연락처 양식을 입력해주세요.");
			} else {
				System.out.println("연락처 확인되었습니다.");
				break;
			}
		}
		member.setMemberTel(tel);		
		update2();
	}	
	
	public void updateStartdate() {
		update1();
		num = 3;
		System.out.println("수정 등록일 (YYYY-MM-DD)>");
		Date date = Date.valueOf(sc.nextLine());
		member.setMemberStartdate(date);

		System.out.println("기간 선택> 1) 1일 | 2) 7일 | 3) 30일");
		day = Integer.parseInt(sc.nextLine());	
		update2();
	}
	
	//좌석 수정 
	public void updateSeat() {		
		update1();
		num = 4;	
		int seatNo = 0;
		while(true) {
			System.out.println("수정 좌석번호>");
			seatNo = Integer.parseInt(sc.nextLine());
			if(seatNo > 30) {
				System.out.println("존재하지 않는 좌석입니다.");
			} else {
				System.out.println("좌석이 선택되었습니다.");
				break;
			}
		}
		seat.setSeatNo(seatNo);
		update2();		
	}
		
	public void updateLocker() {
		
	}

	public void update1() {
		System.out.println("[회원 정보 수정]");
		System.out.println("아이디>");
		String id = sc.nextLine();
		member.setMemberId(id);
	}
	
	public void update2() {
		int result = MemberDAO.getInstance().updateMember(member, seat, num, day);		
		if(result>0) {
			System.out.println("회원 정보를 수정하였습니다.");
		} else {
			System.out.println("회원 정보를 수정하지 못했습니다.");
		}
	}
	
	
	//회원 정보 삭제
	public void deleteMember() {
		System.out.println("[회원 정보 삭제]");
		System.out.println("아이디>");
		String id = sc.nextLine();
		
		int result = MemberDAO.getInstance().deleteMember(id);
		if(result>0) {
			System.out.println("회원 정보를 삭제하였습니다.");
		} else {
			System.out.println("회원 정보를 삭제하지 못했습니다.");
		}
	}


	
	
}
