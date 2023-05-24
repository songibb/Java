package com.yedam.seat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Seat {

//	SEAT_NO   NOT NULL NUMBER       
//	SEAT_USE  NOT NULL CHAR(1)      
//	MEMBER_ID          VARCHAR2(20) 
	
	private int seatNo;
	private String seatUse;
	private String memberId;
	
	private String memberName;
	private int seatPeriod;

	
}
