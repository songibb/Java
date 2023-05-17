package quiz;

public class Application {

	public static void main(String[] args) {
		//문제2
		Card c = new Card("5432-4567-9534-3657", "20251203", "253");
		c.showCardInfo();
		
		TossCard c2 = new TossCard("5432-4567-9534-3657", "20251203", "253", "신빛용");
		c2.showCardInfo();
		
		DGBCard c3 = new DGBCard("5432-4567-9534-3657", "20251203", "253", "신빛용");
		c3.showCardInfo();
		
		//문제3
		int price = 10000;
		Payment card = new CardPayment(0.08);
		card.showInfo();
		System.out.println("온라인 결제 금액 : " + card.online(price));
		System.out.println("오프라인 결제 금액 : " + card.offline(price));
		
		Payment simple = new SimplePayment(0.05);
		simple.showInfo();
		System.out.println("온라인 결제 금액 : " + simple.online(price));
		System.out.println("오프라인 결제 금액 : " + simple.offline(price));
	}

}
