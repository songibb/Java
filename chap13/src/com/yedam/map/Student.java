package com.yedam.map;

public class Student {

	public int sno;
	public String sname;
	
	public Student(int sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	@Override
	public int hashCode() {
		
//		return sno + sname.hashCode();
		return sno;   //sno만 같아도 같은 객체로 보게 함
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
//			return (sno == std.sno) && (sname.equals(std.sname));
			return (sno == std.sno);  //sno만 같아도 같은 객체로 보게 함
		}
		return false;
	}
	
	

}
