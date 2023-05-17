package quiz;

public class TossCard extends Card {
	
	//필드
	String company;
	String cardStaff;

	//생성자
	TossCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.company = "Toss";
		this.cardStaff = cardStaff;
				
	}
	
	//메소드
	public void showCardInfo(){
		System.out.println("카드정보 - Card NO, " + cardNo);
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}

}
