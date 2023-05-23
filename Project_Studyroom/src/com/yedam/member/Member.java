package com.yedam.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Member {

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberTel;
	private Date memberStartdate;
	private Date memberEnddate;
	private String memberAuth;
	
}
