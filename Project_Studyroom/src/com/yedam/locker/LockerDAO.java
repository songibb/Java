package com.yedam.locker;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class LockerDAO extends DAO{

	public static LockerDAO lDao = new LockerDAO();
	
	private LockerDAO() {
		
	}
	public static LockerDAO getInstance() {
		return lDao;
	}
	
	//locker테이블에 자리 만들기
	public int lockerSetting() {
		int result = 0;
		try {
			conn();
			String sql="";
			for(int i = 1; i<=10; i++) {		
				sql = "INSERT INTO locker\r\n"
						+ "VALUES(?,'N',null,null,null)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				result = pstmt.executeUpdate();	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//전체 사물함 조회
	public List<Locker> getLockerList(){
		List<Locker> list = new ArrayList<>();
		Locker locker = null;
		try {
			conn();
			String sql = "SELECT l.locker_no, l.locker_use, m.member_id, m.member_name, l.locker_startdate, l.locker_enddate, s.seat_startdate, s.seat_enddate\r\n" + 
					"FROM locker l \r\n" + 
					"LEFT JOIN member m ON l.member_id = m.member_id\r\n" + 
					"LEFT JOIN seat s ON l.member_id = s.member_id\r\n" + 
					"ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				locker = new Locker();
				locker.setLockerNo(rs.getInt("locker_no"));
				locker.setLockerUse(rs.getString("locker_use"));
				locker.setMemberId(rs.getString("member_id"));
				locker.setMemberName(rs.getString("member_name"));
				locker.setLockerStartdate(rs.getDate("locker_startdate"));
				locker.setLockerEnddate(rs.getDate("locker_enddate"));
				locker.setSeatStartdate(rs.getDate("seat_startdate"));
				locker.setSeatEnddate(rs.getDate("seat_enddate"));
				list.add(locker);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//미사용 사물함 조회
	public List<Locker> getNoUseLocker(){
		List<Locker> list = new ArrayList<>();
		Locker locker = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM locker\r\n"
					+ "WHERE locker_use = 'N'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				locker = new Locker();
				locker.setLockerNo(rs.getInt("locker_no"));
				locker.setLockerUse(rs.getString("locker_use"));
				list.add(locker);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//사물함 등록
	public int insertLocker(Locker locker, int day) {
		int result = 0;
		try {
			conn();
			String sql = "";			
			if(day==1) {
				sql = "UPDATE locker\r\n"
						+ "SET locker_use = 'Y', locker_startdate = sysdate, locker_enddate = sysdate+1, member_id = ?\r\n"
						+ "WHERE locker_no = ?";
			} else if(day==2) {
				sql = "UPDATE locker\r\n"
						+ "SET locker_use = 'Y', locker_startdate = sysdate, locker_enddate = sysdate+7, member_id = ?\r\n"
						+ "WHERE locker_no = ?";
			} else if(day==3) { 
				sql = "UPDATE locker\r\n"
						+ "SET locker_use = 'Y', locker_startdate = sysdate, locker_enddate = sysdate+30, member_id = ?\r\n"
						+ "WHERE locker_no = ?";
			}	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, locker.getMemberId());
			pstmt.setInt(2, locker.getLockerNo());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	//사물함 해지
	public int deleteLocker(Locker locker) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE locker \r\n"
					+ "SET locker_no = (SELECT locker_no FROM locker WHERE member_id = ?), locker_use = 'N', locker_startdate = null, locker_enddate = null, member_id = null\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, locker.getMemberId());
			pstmt.setString(2, locker.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//만료 사물함 조회
	int result = 0;
	public List<Locker> endLockerList(){
		List<Locker> list = new ArrayList<>();
		Locker locker = null;
		try {
			conn();
			String sql = "SELECT * FROM locker WHERE TO_CHAR(locker_enddate) <= TO_CHAR(sysdate)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				locker = new Locker();
				locker.setLockerNo(rs.getInt("locker_no"));
				locker.setMemberId(rs.getString("member_id"));
				list.add(locker);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
}
