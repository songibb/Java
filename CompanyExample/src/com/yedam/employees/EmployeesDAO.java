package com.yedam.employees;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class EmployeesDAO extends DAO{
	//싱글톤 -> DB에 접속   
	private static EmployeesDAO empDao = null;
	
	private EmployeesDAO() {
		
	}
	public static EmployeesDAO getInstance() {
		if(empDao == null) {
			empDao = new EmployeesDAO();
		}
		return empDao;
	}

	
	//전체 조회
	public List<Employees> getEmployeesList(){    //list 활용해서 employees 정보를 담아줌
		List<Employees> list = new ArrayList<>();
		Employees emp = null;
		try{
			conn();
			String sql = "SELECT * FROM employees";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);  
			
			while(rs.next()) {
				emp = new Employees();   //emp에 데이터 넣어줄 객체 생성
				emp.setEmployeeId(rs.getInt("employee_id"));   //객체에 데이터 넣어줌    
				emp.setLastName(rs.getString("last_name"));   	//""안에는 조회된 결과에 따른 컬럼명을 입력함 
				emp.setEmail(rs.getString("email"));			//만약 as로 컬럼명을 별칭으로 바꾸면 그 별칭을 넣어야함
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				list.add(emp);  //리스트에 객체의 데이터를 넣어줌 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {  //DB연결 후 해제하기 위해
			disconn();
		}
		
		return list;
	}
	
	
	//단건 조회(한건 조회)
	public Employees getEmployee(int empid) {   //employee_id 가 주요키라서 받아옴
		Employees emp = null;  	//null이면 조회 안됨, 객체가 존재하면 null이 아니고 조회됨
		try {
			conn();
			String sql = "SELECT * FROM employees WHERE employee_id =?";  //? -> preparestatement사용
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empid);   //(몇번째 물음표, 들어갈 값)
			rs = pstmt.executeQuery();
			
			//한건만 조회이므로 while쓰지 않고 한번만 물어보면 됨
			if(rs.next()) {   //rs.next() -> 데이터 존재하는지 확인   
				emp = new Employees(); //조회된 데이터 있을 때 객체 생성
				emp.setEmployeeId(rs.getInt("employee_id"));   //객체에 데이터 넣어줌    
				emp.setLastName(rs.getString("last_name"));   	//""안에는 조회된 결과에 따른 컬럼명을 입력함 
				emp.setEmail(rs.getString("email"));			//만약 as로 컬럼명을 별칭으로 바꾸면 그 별칭을 넣어야함
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getDate("hire_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return emp;
	}
	
	
	//등록(insert)
	public int insertEmp(Employees emp) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO employees("
					+ "employee_id, last_name, email, hire_date, job_id)"  //테이블의 모든 데이터 입력시 컬럼명 생략 가능 -> value의 ?순서가 컬럼 순서와 일치해야함
					+ "VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());  
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setDate(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			
			result = pstmt.executeUpdate();   //진행된 횟수가 result에 들어감 나옴  -> 실행한 insert의 횟수
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}
