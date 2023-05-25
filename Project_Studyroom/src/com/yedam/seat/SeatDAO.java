package com.yedam.seat;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;


public class SeatDAO extends DAO{
	
	public static SeatDAO sDao = null;
	
	private SeatDAO() {
		
	}
	
	public static SeatDAO getInstance() {
		if(sDao == null) {
			sDao = new SeatDAO();
		}
		return sDao;
	}
	
	//seat테이블에 자리 만들기
	public int seatSetting() {
		int result = 0;
		try {
			conn();
			String sql="";
			for(int i = 0; i<=3; i++) {
				for(int j = 0; j<=4; j++) {
					sql = "INSERT INTO seat\r\n"
							+ "VALUES(seat_seatno_seq.NEXTVAL,?,?,'N',null)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, i);
					pstmt.setInt(2, j);
					result = pstmt.executeUpdate();	
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	//전체 좌석 조회
	public List<Seat> getSeatList() {
		List<Seat> list = new ArrayList<>();
		Seat seat = null;
		try {
			conn();
			String sql = "SELECT s.seat_no, s.seat_use, m.member_id, m.member_name, (m.member_enddate-sysdate) AS \"남은 기간\"\r\n"
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
	

	//좌석 등록
	public int insertSeat(Seat seat) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE seat\r\n"
					+ "SET seat_use = 'Y', member_id = ?\r\n"
					+ "WHERE seat_no = ?";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, seat.getMemberId());
			pstmt.setInt(2, seat.getSeatNo());
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	

	//좌석 해지
	public int deleteSeat(Seat seat) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE seat\r\n"
					+ "SET seat_no = (SELECT seat_no FROM seat WHERE  member_id = ?), \r\n"
					+ "seat_row = (SELECT seat_row FROM seat WHERE  member_id = ?),\r\n"
					+ "seat_column = (SELECT seat_column FROM seat WHERE  member_id = ?),\r\n"
					+ "seat_use = 'N', member_id = null\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seat.getMemberId());
			pstmt.setString(2, seat.getMemberId());
			pstmt.setString(3, seat.getMemberId());
			pstmt.setString(4, seat.getMemberId());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
}
