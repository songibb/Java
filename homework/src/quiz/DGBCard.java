package quiz;

public class DGBCard extends Card{
	
	//필드
	String company;
	String cardStaff;
	
	
	DGBCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.company = "대구은행";
		this.cardStaff = cardStaff;
	}
	
	public void showCardInfo() {
		System.out.println("카드정보 (Card NO : " + cardNo + ", 유효기간 : " + validDate + ", CVC : " + cvc + ")");
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}

}
