package com.yedam.admin;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.Member;

public class AdminDAO extends DAO{
	
	
	//전체 회원 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECE * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberTel(rs.getString("member_tel"));
				member.setMemberStartdate(rs.getDate("member_startdate"));
				member.setMemberEnddate(rs.getDate("member_enddate"));
				member.setMemberAuth(rs.getString("member_auth"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	
	//개별 회원 조회
	//금일 만료 회원 조회
		
	
//	//비밀번호 수정
//	public int updatePw() {
//		
//	}
//	//연락처 수정
//	public int updateTel() {
//		
//	}
//
//	//좌석 수정
//	public int updateSeat() {
//		
//	}
//	//사물함 수정
//	public int updateLocker() {
//		
//	}
//	//등록일 수정
//	public int updateStartdate() {
//		
//	}
	
	public int updateMember(Member member, int num) {
		int result = 0;
		try {
			conn();
			String sql = "";			
			if(num==1) {
				sql = "UPDATE member SET member_pw = ? WHERE member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPw());
			} else if(num==2) {
				sql = "UPDATE member SET member_tel = ? WHERE member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPw());
			} else if(num==3) {
				
			} else if(num==4) {
				
			} else if(num==5) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setDate(1, member.getMemberStartdate());
			}
			
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	
	//회원 삭제

		

}
