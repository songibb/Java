package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.seat.Seat;

public class MemberDAO extends DAO{

	public static MemberDAO mDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(mDao == null) {
			mDao = new MemberDAO();
		}
		return mDao;
	}
	
	
	//로그인
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM member m \r\n"
					+ "LEFT JOIN seat s ON m.member_id = s.member_id\r\n"
					+ "LEFT JOIN locker l ON m.member_id = l.member_id\r\n"
					+ "LEFT JOIN reserveseat r ON m.member_id = r.member_id\r\n"
					+ "WHERE m.member_id = ? \r\n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberAuth(rs.getString("member_auth"));
				member.setSeatNo(rs.getInt("seat_no"));
				member.setSeatUse(rs.getString("seat_use"));
				member.setSeatStartdate(rs.getDate("seat_startdate"));
				member.setSeatEnddate(rs.getDate("seat_enddate"));
				member.setLockerNo(rs.getInt("locker_no"));
				member.setLockerUse(rs.getString("locker_use"));
				member.setLockerStartdate(rs.getDate("locker_startdate"));
				member.setLockerEnddate(rs.getDate("locker_enddate"));
				member.setReserveSeatNo(rs.getInt("reserve_seat_no"));
				member.setReserveSeatDate(rs.getDate("reserve_seat_date"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	
	//회원가입	
	public int insertNormal(Member member) {
		int result = 0;		
		try {
			conn();
			String sql = "INSERT INTO member VALUES((SELECT NVL(MAX(member_no),0)+1 FROM member),?,?,?,?,sysdate,'N')";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberTel());		
			result = pstmt.executeUpdate();							
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}		
		return result;
	}	
	
	public int insertAdmin(Member member) {
		int result = 0;		
		try {
			conn();
			String sql = "INSERT INTO member VALUES((SELECT NVL(MAX(member_no),0)+1 FROM member),?,?,?,?,sysdate,'A')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberTel());			
			result = pstmt.executeUpdate();							
		} catch(Exception e) {
			e.printStackTrace();
		} finally {  
			disconn();
		}		
		return result;
	}
	
	
	
	//전체 회원 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT *\r\n" + 
					"FROM member m LEFT JOIN seat s ON m.member_id = s.member_id\r\n" + 
					"ORDER BY member_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setSeatStartdate(rs.getDate("seat_startdate"));
				member.setSeatEnddate(rs.getDate("seat_enddate"));
				member.setMemberAuth(rs.getString("member_auth"));
				list.add(member);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//개별 회원 조회
//	public Member getMember(String id) {
//		Member member = null;
//		try {
//			conn();
//			String sql = "SELECT *\r\n" + 
//					"FROM member m LEFT JOIN seat s ON m.member_id = s.member_id\r\n" + 
//					"WHERE m.member_id = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				member = new Member();
//				member.setMemberNo(rs.getInt("member_no"));
//				member.setMemberId(rs.getString("member_id"));
//				member.setMemberPw(rs.getString("member_pw"));
//				member.setMemberName(rs.getString("member_name"));
//				member.setMemberTel(rs.getString("member_tel"));
//				member.setSeatStartdate(rs.getDate("seat_startdate"));
//				member.setSeatEnddate(rs.getDate("seat_enddate"));
//				member.setMemberAuth(rs.getString("member_auth"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//		return member;
//	}
	
	//만료 회원 조회
	int result=0;
	public List<Member> endMemberList(){		
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM member m LEFT JOIN seat s ON m.member_id = s.member_id\r\n"
					+ "WHERE TO_CHAR(s.seat_enddate) <= TO_CHAR(sysdate)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setSeatNo(rs.getInt("seat_no"));
				list.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	

	
	//회원 정보 수정
	public int updateMember(Member member, Seat seat, int num, int day) {
		int result = 0;
		try {
			conn();
			String sql = "";	
			
			if(num==1) {
				sql = "UPDATE member SET member_pw = ? WHERE member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPw());
				pstmt.setString(2, member.getMemberId());
				result = pstmt.executeUpdate();	
			} else if(num==2) {
				sql = "UPDATE member SET member_tel = ? WHERE member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberTel());
				pstmt.setString(2, member.getMemberId());
				result = pstmt.executeUpdate();	
			} else if(num==3) {
				sql = "UPDATE seat SET seat_startdate = ? WHERE member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setDate(1, seat.getSeatStartdate());
				pstmt.setString(2, member.getMemberId());
				result = pstmt.executeUpdate();
				
				String sql2 = "";
				if(day==1) {
					sql2 = "UPDATE seat SET seat_enddate = seat_startdate+1 WHERE member_id = ?";
				} else if(day==2) {
					sql2 = "UPDATE seat SET seat_enddate = seat_startdate+7 WHERE member_id = ?";
				} else if(day==3) { 
					sql2 = "UPDATE seat SET seat_enddate = seat_startdate+30 WHERE member_id = ?";
				}	
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, member.getMemberId());
				result = pstmt.executeUpdate();				
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	

	
	
	//회원 정보 삭제
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sqls = "UPDATE seat\r\n"
					+ "SET seat_no = (SELECT seat_no FROM seat WHERE member_id = ?), \r\n"
					+ "seat_use = 'N', seat_startdate = null, seat_enddate = null, member_id = null\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sqls);
			pstmt.setString(1, id);		
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			
			String sqll = "UPDATE locker \r\n"
					+ "SET locker_no = (SELECT locker_no FROM locker WHERE member_id = ?), locker_use = 'N', locker_startdate = null, locker_enddate = null, member_id = null\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sqll);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			
			String sqlm = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sqlm);
			pstmt.setString(1, id);		
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
		
		
	
	
}
