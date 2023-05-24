package com.yedam.seat;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;


public class SeatDAO extends DAO{
	
	public static SeatDAO sDao = null;
	
	private SeatDAO() {
		
	}
	
	public static SeatDAO getInstacne() {
		if(sDao == null) {
			sDao = new SeatDAO();
		}
		return sDao;
	}
	
	
	//전체 좌석 조회
	public List<Seat> getSeatList() {
		List<Seat> list = new ArrayList<>();
		Seat seat = null;
		try {
			conn();
			String sql = "SELECT s.seat_no, s.seat_use, m.member_id, m.member_name, (m.member_enddate-m.member_startdate) AS \"남은 기간\"\r\n"
					+ "FROM seat s LEFT JOIN member m \r\n"
					+ "ON s.member_id = m.member_id\r\n"
					+ "ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				seat = new Seat();
				seat.setSeatNo(rs.getInt("seat_no"));
				seat.setSeatUse(rs.getString("seat_use"));
				seat.setMemberId(rs.getString("member_id"));
				seat.setMemberName(rs.getString("member_name"));
				seat.setSeatPeriod(rs.getInt("남은 기간"));
				list.add(seat);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//미사용 좌석 조회
	public List<Seat> getNoUseSeat() {
		List<Seat> list = new ArrayList<>();
		Seat seat = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM seat\r\n"
					+ "WHERE seat_use = 'N'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				seat = new Seat();
				seat.setSeatNo(rs.getInt("seat_no"));
				seat.setSeatUse(rs.getString("seat_use"));
				list.add(seat);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	
	
	
	//좌석 배치 현황
	
	
	

	
	//30개의 좌석 만들기
//	public int settingSeat() {
//		int result = 0;
//		try {
//			conn();
//			String sql="";
//			for(int i = 1; i<=30; i++) {
//				sql = "INSERT INTO seat VALUES (i,'N',null)";
//				pstmt = conn.prepareStatement(sql);
//				result = pstmt.executeUpdate();
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return result;
//	}
	
	//좌석 등록
	public int insertSeat(Seat seat) {
		int result = 0;
		try {
			conn();
			String sql = "SELECT * FROM seat";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			sql = "UPDATE seat SET seat_use = 'Y', member_id = ? WHERE seat_no = ? ";
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, seat.getMemberId());
			pstmt.setInt(2, seat.getSeatNo());
			result = pstmt.executeUpdate();
			

//			if(rs.next() == false) {
//				sql = "INSERT INTO seat VALUES (?,'Y',?)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, seat.getSeatNo());
//				pstmt.setString(2, seat.getMemberId());
//				result = pstmt.executeUpdate();
//			} else {
//				
//				
//			}
//			while() {
//				seat = new Seat();
//				seat.setSeatNo(rs.getInt("seat_no"));
//				sql = " INSERT INTO seat VALUES (?,'Y',?)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, seat.getSeatNo());
//				pstmt.setString(2, seat.getMemberId());
//				result = pstmt.executeUpdate();
//			}
//			
//			if(seat.getSeatNo()>=1 && seat.getSeatNo()<=30) {
//				sql = "UPDATE seat SET seat_use = 'Y', member_id = ? WHERE seat_no = ? ";
//				pstmt = conn.prepareStatement(sql);		
//				pstmt.setString(1, seat.getMemberId());
//				pstmt.setInt(2, seat.getSeatNo());
//				result = pstmt.executeUpdate();
//			}else {
//				
//			}
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//좌석 해지
	
	
	
	
}
