package quiz;

public class Person {

	//필드
	String ssn;
	String name;
	String address;
	
	//생성자
	//기본생성자 -> 필드를 초기화 하지 않는다
	Person(){
	}
	//주민등록번호, 이름, 주소를 매개변수로 받아 필드를 초기화한다
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
