package com.yedam.account;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

//lombok
@Getter
@Setter
//@NoArgsConstructor -> 기본생성자
//@Data -> 전부 한번에 생성


public class Account {
	
//	ACCOUNT_ID      NOT NULL VARCHAR2(20) 
//	ACCOUNT_BALANCE          NUMBER       
//	ACCOUNT_CREDATE          DATE         
//	MEMBER_ID                VARCHAR2(20) 
	
	private String accountId;
	private int accountBalance;
	private Date accountCredate;
	private String memberId;
	
	
}
