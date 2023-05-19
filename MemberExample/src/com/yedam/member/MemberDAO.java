package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{
	
	private static MemberDAO memberDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}
	
	//아이디를 활용해서 정보 조회 -> java에서 비교
	//1.로그인 기능
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberGrade(rs.getString("member_grade"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	
	//2.회원가입 기능
	public int insertMember(Member member) {
		int result = 0;
		
		try {
			conn();
			String sql = "INSERT INTO member VALUES(?,?,?,?,'N')";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddr());
//			pstmt.setString(5, member.getMemberGrade());  -> 회원가입하자마자 모든 사람은 일반회원등급을 가질 것이므로 제외
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconn();
		}
		
		return result;
	}
	
	
	
	//전체 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberGrade(rs.getString("member_grade"));
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}		
		
		return list;
		
	}
	
	
	//회원 수정 - 연락처 수정
	public int updatePhone(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_phone = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPhone());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();  //업데이트된 개수가 result에 들어감	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
	//회원 삭제
	public int deleteMember(String id) {
		int result = 0;
		try{
			conn();
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
	
	
	
	
	
}
