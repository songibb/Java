package com.yedam.employees;

import java.sql.Date;

public class Employees {
	//DTO : Data Transfer Object
	//VO : DTO + 기능
	//BEANS(Web) : DTO == VO == BEANS
	
	//DTO 작성시 관례 -> DB에서 사용하는 컬럼명을 이용해서 언더바 대신 소문자+대문자로 연결
	private int employeeId;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	
	
	//private -> getter, setter 작성
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", lastName=" + lastName + ", email=" + email + ", hireDate="
				+ hireDate + ", jobId=" + jobId + "]";
	}

	
	
	
	
	
	
}
