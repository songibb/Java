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
					+ "WHERE m.member_id = ? \r\n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberStartdate(rs.getDate("member_startdate"));
				member.setMemberEnddate(rs.getDate("member_enddate"));
				member.setMemberAuth(rs.getString("member_auth"));
				member.setSeatNo(rs.getInt("seat_no"));
				member.setSeatUse(rs.getString("seat_use"));
				member.setLockerNo(rs.getInt("locker_no"));
				member.setLockerUse(rs.getString("locker_use"));
				member.setLockerStartdate(rs.getDate("locker_startdate"));
				member.setLockerEnddate(rs.getDate("locker_enddate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	
	//회원가입	
	public int insertNormal(Member member, int day) {
		int result = 0;		
		try {
			conn();
			String sql = "";
			if(day==1) {
				sql = "INSERT INTO member VALUES((SELECT NVL(MAX(member_no),0)+1 FROM member),?,?,?,?,sysdate,sysdate+1,'N')";
			} else if(day==2) {
				sql = "INSERT INTO member VALUES((SELECT NVL(MAX(member_no),0)+1 FROM member),?,?,?,?,sysdate,sysdate+7,'N')";
			} else if(day==3) { 
				sql = "INSERT INTO member VALUES((SELECT NVL(MAX(member_no),0)+1 FROM member),?,?,?,?,sysdate,sysdate+30,'N')";
			}		
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
			String sql = "INSERT INTO member VALUES((SELECT NVL(MAX(member_no),0)+1 FROM member),?,?,?,?,null,null,'A')";
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
			String sql = "SELECT * FROM member ORDER BY member_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberStartdate(rs.getDate("member_startdate"));
				member.setMemberEnddate(rs.getDate("member_enddate"));
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
	public Member getMember(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
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
				member.setMemberStartdate(rs.getDate("member_startdate"));
				member.setMemberEnddate(rs.getDate("member_enddate"));
				member.setMemberAuth(rs.getString("member_auth"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	//만료 회원 조회
	int result=0;
	public List<Member> endMemberList(){		
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM member m JOIN seat s ON m.member_id = s.member_id\r\n"
					+ "WHERE TO_CHAR(m.member_enddate) = TO_CHAR(sysdate)";
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
				sql = "UPDATE member SET member_startdate = ? WHERE member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setDate(1, member.getMemberStartdate());
				pstmt.setString(2, member.getMemberId());
				result = pstmt.executeUpdate();
				
				String sql2 = "";
				if(day==1) {
					sql2 = "UPDATE member SET member_enddate = member_startdate + 1 WHERE member_id = ?";
				} else if(day==2) {
					sql2 = "UPDATE member SET member_enddate = member_startdate + 7 WHERE member_id = ?";
				} else if(day==3) { 
					sql2 = "UPDATE member SET member_enddate = member_startdate + 30 WHERE member_id = ?";
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
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
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
