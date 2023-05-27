package com.yedam.locker;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Locker {

//	LOCKER_NO        NOT NULL NUMBER       
//	LOCKER_USE       NOT NULL CHAR(1)      
//	LOCKER_STARTDATE          DATE         
//	LOCKER_ENDDATE            DATE         
//	MEMBER_ID                 VARCHAR2(20) 

	private int lockerNo;
	private String lockerUse;
	private Date lockerStartdate;
	private Date lockerEnddate;
	private String memberId;
	
	private String memberName;
	private Date seatStartdate;
	private Date seatEnddate;
	
	
}
