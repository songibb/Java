package com.yedam.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Member {
	
	
//	MEMBER_NO                 NUMBER       
//	MEMBER_ID        NOT NULL VARCHAR2(20) 
//	MEMBER_PW                 VARCHAR2(20) 
//	MEMBER_NAME      NOT NULL VARCHAR2(12) 
//	MEMBER_TEL                VARCHAR2(15) 
//	MEMBER_STARTDATE          DATE         
//	MEMBER_ENDDATE            DATE         
//	MEMBER_AUTH               CHAR(1)    

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberTel;
	private Date memberStartdate;
	private Date memberEnddate;
	private String memberAuth;
	
	private int seatNo;
	
	private int lockerNo;
	private Date lockerStartdate;
	private Date lockerEnddate; 
	
	
}
