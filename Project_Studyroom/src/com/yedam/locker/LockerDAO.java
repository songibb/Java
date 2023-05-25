package com.yedam.locker;

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
			for(int i = 1; i<=20; i++) {		
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
//	public List<Locker> getLockerList(){
//		List<Locker> list = new ArrayList<>();
//		Locker locker = null;
//		try {
//			conn();
//			String sql = "SELECT s.seat_no, s.seat_use, m.member_id, m.member_name, (m.member_enddate-m.member_startdate) AS \"남은 기간\"\r\n"
//					+ "FROM seat s LEFT JOIN member m \r\n"
//					+ "ON s.member_id = m.member_id\r\n"
//					+ "ORDER BY 1";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			
//		}catch(Exception e) {
//			
//		}finally {
//			disconn();
//		}
//		return list;
//	}
	
	
	//미사용 사물함 조회
	
	//사물함 등록
	public int insertLocker(Locker locker, int day) {
		int result = 0;
		try {
			conn();
			String sql = "";			
			if(day==1) {
				sql = "MERGE INTO locker\r\n" + 
						"USING DUAL \r\n" + 
						"ON (locker_no = ?)\r\n" + 
						"WHEN MATCHED THEN\r\n" + 
						"UPDATE SET locker_use = 'Y', locker_startdate = sysdate, locker_enddate = sysdate+1, member_id = ?\r\n" + 
						"WHEN NOT MATCHED THEN\r\n" + 
						"INSERT (locker_no,locker_use,locker_startdate,locker_enddate,member_id) \r\n" + 
						"VALUES (?,'Y',sysdate,sysdate+1,?)";
			} else if(day==2) {
				sql = "MERGE INTO locker\r\n" + 
						"USING DUAL \r\n" + 
						"ON (locker_no = ?)\r\n" + 
						"WHEN MATCHED THEN\r\n" + 
						"UPDATE SET locker_use = 'Y', locker_startdate = sysdate, locker_enddate = sysdate+1, member_id = ?\r\n" + 
						"WHEN NOT MATCHED THEN\r\n" + 
						"INSERT (locker_no,locker_use,locker_startdate,locker_enddate,member_id) \r\n" + 
						"VALUES (?,'Y',sysdate,sysdate+7,?)";
			} else if(day==3) { 
				sql = "MERGE INTO locker\r\n" + 
						"USING DUAL \r\n" + 
						"ON (locker_no = ?)\r\n" + 
						"WHEN MATCHED THEN\r\n" + 
						"UPDATE SET locker_use = 'Y', locker_startdate = sysdate, locker_enddate = sysdate+1, member_id = ?\r\n" + 
						"WHEN NOT MATCHED THEN\r\n" + 
						"INSERT (locker_no,locker_use,locker_startdate,locker_enddate,member_id) \r\n" + 
						"VALUES (?,'Y',sysdate,sysdate+30,?)";
			}	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, locker.getLockerNo());
			pstmt.setString(2, locker.getMemberId());
			pstmt.setInt(3, locker.getLockerNo());
			pstmt.setString(4, locker.getMemberId());
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
					+ "SET locker_no = ?, locker_use = 'N', locker_startdate = null, locker_enddate = null, member_id = null\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, locker.getLockerNo());
			pstmt.setString(2, locker.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
}
