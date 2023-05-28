package com.yedam.seat;

import java.sql.Date;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;
import com.yedam.member.MemberDAO;


public class SeatService {
	Scanner sc = new Scanner(System.in);
	
	//seat테이블에 자리 만들기
	public void seatSetting() {
		System.out.println("[책상과 의자를 놓고 있습니다 ଘ(੭ꆤᴗꆤ)━☆ﾟ.*･]");
		int result = SeatDAO.getInstance().seatSetting();		
		if(result > 0) {
			System.out.println("배치 완료");
		}else {
			System.out.println("배치 실패");
		}
	}
	
	
	//전체 좌석 조회
	public void getSeatList() {
		System.out.println("[전체 좌석 조회]");
		List<Seat> list = SeatDAO.getInstance().getSeatList();	
		for(Seat seat : list) {
			System.out.println("좌석 번호 : " + seat.getSeatNo());
			System.out.println("좌석 상태 : " + (seat.getSeatUse().equals("Y") ? "사용중" : "사용가능"));
			if(seat.getSeatUse().equals("Y")) {
				System.out.println("아이디 : " + seat.getMemberId() + ", 이름 : " + seat.getMemberName());
				System.out.println("남은 기간 : " + seat.getSeatPeriod() + "일");
			}	
			System.out.println("==================================================================🧡");
		}
	}

	
	//좌석 배치도
	public void getNowSeat() {	
		System.out.println("[좌석 배치 현황]");
		System.out.println("[사용중 : ■  사용가능 : □]");
		
		List<Seat> list = SeatDAO.getInstance().getSeatList();	
		List<Seat> list2 = SeatDAO.getInstance().getNoUseSeat();
		
		for(int i = 0; i<list.size();i++) {
			System.out.print(list.get(i).getSeatUse().equals("Y") ? list.get(i).getSeatNo()+" ■ \t" :  list.get(i).getSeatNo()+" □ \t");
			if((i+1) % 5 == 0) {
				System.out.println();
			}
		}
		
		if(list2.size()==0) {
			System.out.println();
			System.out.println("※ 사용가능한 좌석이 없습니다. 독서실을 이용하려면 예약이 필요합니다.");
		}

	}
	
	
	//날짜별 좌석 조회
	
	public void getDateSeat() {	
		System.out.println("[날짜별 좌석 조회]");
		Date seatDate = null;
		while(true) {
			System.out.println("조회할 날짜 (YYYY-MM-DD)>");
			String date = sc.nextLine();
			if(date.length()!=10) {
				System.out.println("날짜 양식에 맞춰 입력해주세요.");
			} else {
				seatDate = Date.valueOf(date);	
				break;
			}
		}
		
		System.out.println("['"+ seatDate +"' 좌석 배치 현황 ]");
		System.out.println("[사용중 : ■  사용가능 : □]");
		List<Seat> list = SeatDAO.getInstance().getDateSeat(seatDate);
		String[] seat = new String[20];

		if(list.isEmpty()) {
			for(int i = 0; i<20; i++) {
				System.out.print((i+1) + " □ \t");
				if((i+1) % 5 == 0) {
					System.out.println();
				}
			}
		} else {
			for(int i = 0; i<seat.length; i++) {	
				for(int j = 0; j<list.size(); j++) {
					if((i+1) == list.get(j).getSeatNo()) {
						seat[i]="Y";				
						break;
					} else {
						seat[i]="N";
					}
				}
			}
			
			for(int i = 0; i<seat.length; i++) {
				System.out.print(seat[i].equals("Y") ? (i+1)+" ■ \t" : (i+1)+" □ \t");
				if((i+1) % 5 == 0) {
					System.out.println();
				}
			}
		}
		
	}
	

	
		
		//데이터를 배열에 다 넣은상태에서 사용
//		for(Seat seat : list) {
//			String[][] seatArr = new String[4][5];
//			for (int i = 0; i < seatArr.length; i++){		
//		    	for(int j = 0; j < seatArr[i].length; j++) {	
//		    		if(seat.getSeatRow()==i && seat.getSeatColumn()==j) {
////		    			if(seat.getSeatUse().equals("Y")) {    	    		
////		    				seatArr[i][j] = " ■ \t";
////		    				System.out.print(seat.getSeatNo()+seatArr[i][j]);
////		    			} else if(seat.getSeatUse().equals("N")) {
////		    				seatArr[i][j] = " □ \t";
////		    				System.out.print(seat.getSeatNo()+seatArr[i][j]);
////		    			}
//		    			System.out.print(seat.getSeatUse().equals("Y") ? seat.getSeatNo()+" ■ \t" : seat.getSeatNo()+" □ \t");	
//		    		}
//		    	}
//		    }
//		}
	
	
	//좌석 등록
	public void insertSeat() {
		System.out.println("[좌석 등록]");		
		Seat seat = new Seat();	
		String id = "";
		int seatNo = 0;
		int day = 0;
		
		
		while(true) {
			System.out.println("아이디>");
			id = sc.nextLine();		
			Member member = MemberDAO.getInstance().login(id);
			if(member.getSeatUse() != null) {
				System.out.println("이미 좌석이 배정된 회원입니다.");
			}else {				
				break;
			}
		}
		seat.setMemberId(id);
		
		while(true) {
			System.out.println("좌석 번호>");
			seatNo = Integer.parseInt(sc.nextLine());
			
			List<Seat> list = SeatDAO.getInstance().getSeatList();	
			
			String[] seatArr = new String[20];
			for(int i = 0; i<seatArr.length; i++) {	
				seatArr[i] = list.get(i).getSeatUse();
			}
			//System.out.println(Arrays.toString(seatArr));
			if(seatArr[seatNo-1].equals("Y")) {
				System.out.println("이미 배정된 좌석입니다. 다시 선택해주세요.");
			} else {
				break;
			}

		}
		seat.setSeatNo(seatNo);

		System.out.println("기간 선택> 1) 1일 | 2) 7일 | 3) 30일");
		day = Integer.parseInt(sc.nextLine());
		
		int result = SeatDAO.getInstance().insertSeat(seat, day);	
		if(result > 0) {
			System.out.println("좌석이 등록되었습니다.");
		}else {
			System.out.println("좌석이 등록되지 않았습니다.");
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
			System.out.println("기간 만료 회원 좌석이 전부 해지되었습니다.");
		}else {
			System.out.println("기간 만료 회원 좌석이 없습니다.");
		}
	}
	
	
	
}
