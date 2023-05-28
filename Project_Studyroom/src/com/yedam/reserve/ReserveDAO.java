package com.yedam.reserve;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class ReserveDAO extends DAO{

	public static ReserveDAO rDao = new ReserveDAO();
	
	private ReserveDAO() {
		
	}

	public static ReserveDAO getInstance() {
		return rDao;
	}
	
	
	//좌석 예약 조회
	public List<Reserve> getReserveSeat(){
		List<Reserve> list = new ArrayList<>();
		Reserve res = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM reserveseat r\r\n"
					+ "LEFT JOIN member m ON r.member_id = m.member_id\r\n"
					+ "ORDER BY reserve_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				res = new Reserve();
				res.setReserveNo(rs.getInt("reserve_no"));
				res.setReserveSeatNo(rs.getInt("reserve_seat_no"));
				res.setReserveSeatDate(rs.getDate("reserve_seat_date"));
				res.setMemberId(rs.getString("member_id"));
				res.setMemberName(rs.getString("member_name"));
				list.add(res);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//예약날짜별 조회
	public List<Reserve> getReserveDate(Date date){
		List<Reserve> list = new ArrayList<>();
		Reserve res = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM reserveseat r\r\n"
					+ "LEFT JOIN member m ON r.member_id = m.member_id\r\n"
					+ "WHERE reserve_seat_date = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				res = new Reserve();
				res.setReserveSeatNo(rs.getInt("reserve_seat_no"));
				res.setReserveSeatDate(rs.getDate("reserve_seat_date"));
				res.setMemberId(rs.getString("member_id"));
				res.setMemberName(rs.getString("member_name"));
				list.add(res);
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	

	

	//좌석 예약 등록
	public int insertReserveSeat(Reserve res) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO reserveseat VALUES((SELECT NVL(MAX(reserve_no),0)+1 FROM reserveseat),?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, res.getReserveSeatNo());
			pstmt.setDate(2, res.getReserveSeatDate());
			pstmt.setString(3, res.getMemberId());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//좌석 예약 취소
	public int deleteReserveSeat(Reserve res) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM reserveseat WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

		
}