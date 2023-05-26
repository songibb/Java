package com.yedam.reserve;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

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
	
	//예약날짜별 조회
	public void getReserveDate() {
		System.out.println("[예약일별 조회]");
		System.out.println("조회 예약일 (YYYY-MM-DD)>");
		Date seatDate = Date.valueOf(sc.nextLine());

		List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);
		System.out.println("<"+ seatDate +">");
		for(Reserve res : list) {			
			if(list == null) {
				System.out.println("조회하신 날짜에는 예약이 없습니다.");
			} else {
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
		
		System.out.println("아이디>");
		res.setMemberId(sc.nextLine());
	
		boolean flag = true;
		while(flag) {	
			System.out.println("예약 좌석 번호>");
			int seatNo = Integer.parseInt(sc.nextLine());
			Date seatDate;
			while(true) {
				System.out.println("예약 등록일 (YYYY-MM-DD)>");
				String date = sc.nextLine();
				if(date.length()!=10) {
					System.out.println("날짜 양식에 맞춰 입력해주세요.");		
				} else {
					seatDate = Date.valueOf(sc.nextLine());	
					break;
				}
			}
			List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);

			for(Reserve rese : list) {
				if(seatNo == rese.getReserveSeatNo()) {
					System.out.println("이미 예약된 좌석입니다. 다시 선택해주세요.");
					break;
				} else {
					res.setReserveSeatNo(seatNo);
					res.setReserveSeatDate(seatDate);
					flag = false;
				}
				int result = ReserveDAO.getInstance().insertReserveSeat(res);
				if(result > 0) {
					System.out.println("좌석이 예약되었습니다.");
				}else {
					System.out.println("좌석이 예약되지 않았습니다.");
				}
				
			}
		}
		
	}
	
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
