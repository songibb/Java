package com.yedam.API;

public class Member {
	//필드
	public String id;   
	
	//생성자
	public Member(String id) {
		this.id = id;
	}

	//메소드
	@Override
	public boolean equals(Object obj) {   //object는 부모라서 obj에 member2가 담길 수 있음.  Object obj = memeber2 
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(id.equals(member.id)) {    //equals ->문자열 비교
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	
}
