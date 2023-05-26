package com.yedam.reserve;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserve {
	
//	RESERVE_NO        NOT NULL NUMBER       
//	RESERVE_SEAT_NO            NUMBER       
//	RESERVE_SEAT_DATE          DATE         
//	MEMBER_ID                  VARCHAR2(20) 
	
	private int reserveNo;
	private int reserveSeatNo;
	private Date reserveSeatDate;
	private String memberId;
	
	private String memberName;
	
	

}
