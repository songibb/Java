package quiz;

public class Card {
	//필드
	String cardNo;
	String validDate;  
	String cvc;			
	
	//생성자
	Card(String cardNo, String validDate, String cvc){
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}
	
	//메소드
	public String getCardNo() {
		return cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public String getCvc() {
		return cvc;
	}
	
	public void showCardInfo() {
		System.out.println("카드정보 ( Card NO : " + cardNo + ", 유효기간 : " + validDate + ", CVC : " + cvc + " )");
	}
	
	
	
	
	
}
