package com.yedam.reserve;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.yedam.member.Member;
import com.yedam.member.MemberDAO;
import com.yedam.seat.Seat;
import com.yedam.seat.SeatDAO;
import com.yedam.seat.SeatService;

public class ReserveService {

	
	Scanner sc = new Scanner(System.in);
	SeatService ss = new SeatService();
	
	//예약 조회
	public void getReserveSeat() {
		System.out.println("[예약 기록 전체 조회]");
		List<Reserve> list = ReserveDAO.getInstance().getReserveSeat();
		
		for(Reserve res : list) {
			System.out.println("번호 : " + res.getReserveNo() + ", 예약 좌석 번호 : " + res.getReserveSeatNo() + ", 예약일 : " + res.getReserveSeatDate() 
								+ ", 아이디 : " + res.getMemberId() + ", 이름 : " + res.getMemberName());
			System.out.println("===================================================================");
		}
	}
	

	//예약 날짜별 조회
	
	public void getReserveDate() {
		System.out.println("[예약 날짜별 조회]");	
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
		System.out.println();
	
		List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);
		System.out.println("['" + seatDate + "' 예약 상세 정보]");
		if(list.isEmpty()) {
			System.out.println("조회하신 날짜에는 예약이 없습니다.");
		} else {
			for(Reserve res : list) {						
				System.out.println("예약한 좌석 번호 : " + res.getReserveSeatNo() + ", 예약일 : " + res.getReserveSeatDate() 
								+ ", 아이디 : " + res.getMemberId() + ", 이름 : " + res.getMemberName());
				System.out.println("===================================================================");
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
		
		while(true) {
			while(true) {
				System.out.println("예약일 (YYYY-MM-DD)>");
				seatDate = Date.valueOf(sc.nextLine());	
				
				List<Seat> list1 = SeatDAO.getInstance().getDateSeat(seatDate);
				String[] seat1 = new String[20];
				if(list1.isEmpty()) {
					for(int i = 0; i<20; i++) {
						seat1[i]="N";
					}
				} else {
					for(int i = 0; i<seat1.length; i++) {	
						for(int j = 0; j<list1.size(); j++) {
							if((i+1) == list1.get(j).getSeatNo()) {
								seat1[i]="Y";				
								break;
							} else {
								seat1[i]="N";
							}
						}
					}
				}
				
//				System.out.println(Arrays.toString(seat1));
				boolean isSeat = Arrays.asList(seat1).contains("N");
				if(isSeat == false) {
					System.out.println("※ 예약가능한 좌석이 없습니다. 예약일을 다시 입력해주세요.");	
				}else {
					System.out.println("예약가능한 좌석번호는 다음과 같습니다.");
					for(int i = 0; i<seat1.length; i++) {
						if(seat1[i].contentEquals("N")) {
							System.out.print((i+1)+" ");
						}
					}
					System.out.println();
					break;
					
				}
			}
			
			

			System.out.println("예약 좌석 번호>");
			seatNo = Integer.parseInt(sc.nextLine());
			
			List<Reserve> list = ReserveDAO.getInstance().getReserveDate(seatDate);
			String[] seat = new String[20];
		
			if(list.size()!=0) {
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
			} else {
				for(int i = 0; i<seat.length; i++) {
					seat[i]="N";
				}
			}
			//System.out.println(Arrays.toString(seat));
			if(seat[seatNo-1].equals("Y")) {
				System.out.println("이미 예약된 좌석입니다. 예약가능한 좌석을 다시 확인하세요.");
			} else {
				break;
			}
		}
		res.setReserveSeatDate(seatDate);
		res.setReserveSeatNo(seatNo);
		
		int result = ReserveDAO.getInstance().insertReserveSeat(res);
		if(result > 0) {
			System.out.println("좌석이 예약되었습니다.");
		}else {
			System.out.println("좌석이 예약되지 않았습니다.");
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
