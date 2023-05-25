package com.yedam.seat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Seat {

//	SEAT_NO     NOT NULL NUMBER       
//	SEAT_ROW    NOT NULL NUMBER       
//	SEAT_COLUMN NOT NULL NUMBER       
//	SEAT_USE    NOT NULL CHAR(1)      
//	MEMBER_ID            VARCHAR2(20) 

	private int seatNo;
	private int seatRow;
	private int seatColumn;
	private String seatUse;
	private String memberId;
	
	private String memberName;
	private int seatPeriod;

	
}
