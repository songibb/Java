package com.yedam.reserve;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;
import com.yedam.member.MemberDAO;
import com.yedam.seat.Seat;
import com.yedam.seat.SeatDAO;

public class ReserveService {

	
	Scanner sc = new Scanner(System.in);
	
	//예약 조회
	public void getReserveSeat() {
		System.out.println("[좌석 예약 조회]");
		List<Reserve> list = ReserveDAO.getInstance().getReserveSeat();
		
		for(Reserve res : list) {
			System.out.println("예약한 좌석 번호 : " + res.getReserveSeatNo() + ", 예약일 : " + res.getReserveSeatDate() 
								+ ", 아이디 : " + res.getMemberId() + ", 이름 : " + res.getMemberName());
			System.out.println("==================================================================🧡");
		}
	}
	
	
	Date seatDate = null;
	//날짜별 예약 현황
	public void nowReserveSeat() {
		try {
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
			System.out.println();
			System.out.println("['"+ seatDate +"' 좌석 예약 현황 ]");			
			System.out.println("사용중 : ■  사용가능 : □");
			List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);
			String[] seat = new String[20];
			for(int i = 0; i<seat.length; i++) {		
				for(int j = 0; j<list.size(); j++) {
					if((i+1) == list.get(j).getReserveSeatNo()) {
						seat[i]="Y";				
						break;
					} else {
						seat[i]="N";
					}
				}
			}
			for(int i = 0; i<seat.length ;i++) {
				System.out.print(seat[i].equals("Y") ? (i+1)+" ■ \t" : (i+1)+" □ \t");
				if((i+1) % 5 == 0) {
					System.out.println();
				}
			}		
		} catch(NullPointerException e) {
			for(int i = 0; i<20; i++) {
				System.out.print((i+1) + " □ \t");
				if((i+1) % 5 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("조회하신 날짜에는 예약이 없습니다.");
		}	
	}
	

	
	//예약 날짜별 상세 조회
	public void getReserveDate() {
		System.out.println("[예약 날짜별 조회]");
		
		nowReserveSeat();
		System.out.println();
	
		List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);
		for(Reserve res : list) {			
			if(list != null) {
				System.out.println("[예약 상세 정보]");
				System.out.println("예약한 좌석 번호 : " + res.getReserveSeatNo() + ", 예약일 : " + res.getReserveSeatDate() 
									+ ", 아이디 : " + res.getMemberId() + ", 이름 : " + res.getMemberName());
				System.out.println("==================================================================🧡");
			}	
		}	
	}
	
	
	
	//예약 등록
	public void insertReserveSeat() {
		System.out.println("[좌석 예약 등록]");
		Reserve res = new Reserve();
		String id = "";
		Date seatDate = null;
		int seatNo = 0;
		
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
		res.setMemberId(id);
		System.out.println("예약일 (YYYY-MM-DD)>");
		String date = sc.nextLine();
		seatDate = Date.valueOf(date);	
		System.out.println("예약 좌석 번호>");
		seatNo = Integer.parseInt(sc.nextLine());

//		while(true) {
//			System.out.println("예약일 (YYYY-MM-DD)>");
//			String date = sc.nextLine();
//			seatDate = Date.valueOf(date);	
//			if(date.length()!=10) {
//				System.out.println("날짜 양식에 맞춰 입력해주세요.");
//			} else {
//				seatDate = Date.valueOf(date);
//				break;
//			}                                       
//		}
	
//		while(true) {
//			System.out.println("예약 좌석 번호>");
//			seatNo = Integer.parseInt(sc.nextLine());
//			List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);
//			for(int i = 0; i<list.size(); i++) {
//				if(seatNo == list.get(i).getReserveSeatNo()) {
//					System.out.println("이미 예약된 좌석입니다. 예약가능한 좌석을 다시 확인하세요.");	
//				} else {			
//					break;
//				}
//			}
//		}
		res.setReserveSeatDate(seatDate);
		res.setReserveSeatNo(seatNo);	
		int result = ReserveDAO.getInstance().insertReserveSeat(res);
		if(result > 0) {
			System.out.println("좌석이 예약되었습니다.");
		}else {
			System.out.println("좌석이 예약되지 않았습니다.");
		}
		
		
	}
		
	
//	for(Reserve rese : list) {
//		if(seatNo == rese.getReserveSeatNo()) {
//			System.out.println("이미 예약된 좌석입니다. 다시 선택해주세요.");
//			break;
//		} else {
//			res.setReserveSeatNo(seatNo);
//			res.setReserveSeatDate(seatDate);
//			flag = false;
//		}
//		int result = ReserveDAO.getInstance().insertReserveSeat(res);
//		if(result > 0) {
//			System.out.println("좌석이 예약되었습니다.");
//		}else {
//			System.out.println("좌석이 예약되지 않았습니다.");
//		}
//		
//	}
	
	
	//예약 취소
	public void deleteReserveSeat() {
		System.out.println("[좌석 예약 취소]");
		Reserve res = new Reserve();
		
		System.out.println("아이디>");
		res.setMemberId(sc.nextLine());
		
		int result = ReserveDAO.getInstance().deleteReserveSeat(res);
		if(result > 0) {
			System.out.println("예약이 취소되었습니다.");
		} else {
			System.out.println("예약이 취소되지 않았습니다.");
		}
	}
	
}
