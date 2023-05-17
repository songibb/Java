package quiz;

public class Person {

	//필드
	String ssn;
	String name;
	String address;
	
	//생성자
	Person(){
	}

	Person(String ssn, String name, String address){
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	
	//메소드
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
