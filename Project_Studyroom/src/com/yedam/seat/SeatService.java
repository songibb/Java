package com.yedam.seat;

import java.util.List;
import java.util.Scanner;

public class SeatService {
	Scanner sc = new Scanner(System.in);
	

	
	//전체 좌석 조회
	public void getSeatList() {
		List<Seat> list = SeatDAO.getInstacne().getSeatList();
		System.out.println("[전체 좌석 조회]");
		for(Seat seat : list) {
			System.out.println("좌석 번호 : " + seat.getSeatNo());
			System.out.println("좌석 상태 : " + (seat.getSeatUse().equals("Y") ? "사용중" : "사용가능"));
			System.out.println("아이디 : " + seat.getMemberId());
			System.out.println("이름 : " + seat.getMemberName());
			System.out.println("남은 기간 : " + seat.getSeatPeriod() + "일");
			System.out.println("========================🧡 ");
		}
	}
	
	
	//미사용 좌석 조회
	public void getNoUseSeat() {
		
		List<Seat> list = SeatDAO.getInstacne().getNoUseSeat();
		System.out.println("[미사용 좌석 조회]");
	
		if(list!=null) {
			for(Seat seat : list) {
				System.out.println(seat.getSeatNo()+ " : " +(seat.getSeatUse().equals("Y") ? "사용중" : "사용가능"));
			}
		} else {
			System.out.println("빈 좌석이 없습니다. 예약하시기 바랍니다.");
		}

		
		
	}
	
	
	
	//좌석 배치 현황
	
	
	//좌석 등록
	public void insertSeat() {
		System.out.println("[좌석 등록]");
		Seat seat = new Seat();
		
		System.out.println("아이디>");
		seat.setMemberId(sc.nextLine());		
		System.out.println("좌석 번호>");
		seat.setSeatNo(Integer.parseInt(sc.nextLine()));
		
		int result = SeatDAO.getInstacne().insertSeat(seat);
		
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
		System.out.println("좌석 번호>");
		seat.setSeatNo(Integer.parseInt(sc.nextLine()));

		int result = SeatDAO.getInstacne().deleteSeat(seat);
		
		if(result > 0) {
			System.out.println("좌석이 해지되었습니다.");
		}else {
			System.out.println("좌석이 해지되지 않았습니다.");
		}
	}
	
	
}
