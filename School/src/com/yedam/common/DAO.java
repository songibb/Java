package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	//DAO : Data Access Object
	//JDBC를 통해서 JAVA<->DB가 연결이 된다.
	
	//JAVA <-> DB 연결할 때 쓰는 객체
	protected Connection conn = null;
	
	//Query문(SQL, 질의)을 가지고 실행하는 객체
	protected PreparedStatement pstmt = null;
	
	//Query문(SQL, 질의)을 가지고 실행하는 객체
	protected Statement stmt = null;
	
	//SELECT(조회) 결과 값을 반환하는 객체
	protected ResultSet rs = null;
	
	//DB 접속 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "HR";
	String pw = "1234";
	
	//Build Path -> Configure Build Path -> Libraries -> Modulepath 선택 -> Add External JARs -> ojdbc숫자.jar파일 선택
	//Referenced Libraries 안에 jar파일 들어가면 성공
	
	//DB 연결 메소드
	public void conn() {
		try {
			//1. 드라이버 로딩
			Class.forName(driver);
			//2. DB 연결
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB 연결 해제 메소드 (연결 순서의 반대로 실행, if-elseif 사용하면 안됨) 
	//DB에 동시에 접속할 수 있는 인원(connection pool)은 제한되어 있기 때문에, 연걸을 끊어주지 않으면 다른 사람이 사용할 수 없게된다.
	public void disconn() {
		try {
			if(rs != null) { //기본값이 null인데, 연결하고 실행하고 반환하는 객체들을 한번씩이라도 사용하면 null이 아닌 데이터가 담겨져있을 것 
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
