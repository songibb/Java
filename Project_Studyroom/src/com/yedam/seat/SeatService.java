package com.yedam.seat;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;
import com.yedam.member.MemberDAO;

public class SeatService {
	Scanner sc = new Scanner(System.in);
	
	//seat테이블에 자리 만들기
	public void seatSetting() {
		System.out.println("[책상과 의자를 놓고 있습니다.]");
		int result = SeatDAO.getInstance().seatSetting();		
		if(result > 0) {
			System.out.println("셋팅 완료");
		}else {
			System.out.println("셋팅 실패");
		}
	}
	
	
	//전체 좌석 조회
	public void getSeatList() {
		System.out.println("[전체 좌석 조회]");
		List<Seat> list = SeatDAO.getInstance().getSeatList();	
		for(Seat seat : list) {
			System.out.println("좌석 번호 : " + seat.getSeatNo());
			System.out.println("좌석 상태 : " + (seat.getSeatUse().equals("Y") ? "사용중" : "사용가능"));
			System.out.println("아이디 : " + (seat.getMemberId() == null ? "사용가능" : seat.getMemberId()));
			System.out.println("이름 : " + (seat.getMemberName() == null ? "사용가능" : seat.getMemberName()));
			System.out.println("남은 기간 : " + seat.getSeatPeriod() + "일");
			System.out.println("========================🧡 ");
		}
	}
	
	
	//미사용 좌석 조회
	public void getNoUseSeat() {	
		System.out.println("[미사용 좌석 조회]");
		List<Seat> list = SeatDAO.getInstance().getNoUseSeat();
		if(list!=null) {
			for(Seat seat : list) {
				System.out.println(seat.getSeatNo()+ " : " +(seat.getSeatUse().equals("Y") ? "사용중" : "사용가능"));
			}
		} else {
			System.out.println("빈 좌석이 없습니다. 예약하시기 바랍니다.");
		}
	
	}
	
	
	//좌석 배치 현황
	
	public void setting(){
		int[][] seatArr = new int[4][5];
		int i, j, plus; 
	    plus = 0;
	    for (i = 0; i <= 3; i++){
	    	for(j = 0; j <=4; j++) {	
	    		seatArr[i][j]= plus;
	    		plus = plus+1;
	    		int seatNum = seatArr[i][j];
	    		System.out.print((seatNum+1)  + "\t");
	    	}
	        System.out.println();
	    }
	}
	
	public void nowSeat() {
		
		System.out.println("[좌석 배치 현황]");
		List<Seat> list = SeatDAO.getInstance().getSeatList();	
		for(Seat seat : list) {
			String[][] seatArr = new String[4][5];
			for (int i = 0; i <= 3; i++){
		    	for(int j = 0; j <=4; j++) {
		    		if(seat.getSeatRow()==i && seat.getSeatColumn()==j) {
		    			if(seat.getSeatUse().equals("Y")) {    	    		
		    				seatArr[i][j] = "■ \t";
		    				System.out.print(seatArr[i][j]);
		    			} else if(seat.getSeatUse().equals("N")) {
		    				seatArr[i][j] = "□ \t";
		    				System.out.print(seatArr[i][j]);
		    			}
		    		}
		    	}
		    }
		}
		System.out.println();
	}
	
	
	
	
	//좌석 등록
	public void insertSeat() {
		System.out.println("[좌석 등록]");
		Seat seat = new Seat();	
		
		System.out.println("아이디>");
		seat.setMemberId(sc.nextLine());		
		System.out.println("좌석 번호>");
		seat.setSeatNo(Integer.parseInt(sc.nextLine()));
//		seat.setSeatRow((int)Math.floor((seatNo-1)/5));
//		seat.setSeatColumn((seatNo-1)%5);
		
		int result = SeatDAO.getInstance().insertSeat(seat);		
		if(result > 0) {
			System.out.println("좌석이 등록되었습니다.");
		}else {
			System.out.println("좌석이 등록되지 않았습니다.");
		}
	}
	
	
	//금일 만료 회원 좌석 해지
	public void deleteEndSeat() {
		System.out.println("[만료회원 좌석 전체 해지]");
		List<Member> list = MemberDAO.getInstance().endMemberList();
		Seat seat = new Seat();
		int result = 0;
		for(Member mem : list) {
			seat.setMemberId(mem.getMemberId());	
			seat.setSeatNo(mem.getSeatNo());
			result = SeatDAO.getInstance().deleteSeat(seat);
		}	
		if(result > 0) {
			System.out.println("만료회원 좌석이 전부 해지되었습니다.");
		}else {
			System.out.println("만료회원 좌석이 해지되지 않았습니다.");
		}
	}
	
	
	
	//좌석 해지
	public void deleteSeat() {
		System.out.println("[좌석 해지]");
		Seat seat = new Seat();
		
		System.out.println("아이디>");
		seat.setMemberId(sc.nextLine());		

		int result = SeatDAO.getInstance().deleteSeat(seat);	
		if(result > 0) {
			System.out.println("좌석이 해지되었습니다.");
		}else {
			System.out.println("좌석이 해지되지 않았습니다.");
		}
	}
	
	
	
}
