package quiz;

public class SimplePayment implements Payment {
	
	double cardRatio;
	
	SimplePayment(double cardRatio){
		this.cardRatio = cardRatio;
	}
	
	@Override
	public int online(int price) {
		return (int)(price - (price * (ONLINE_PAYMENT_RATIO+cardRatio)));
	}

	@Override
	public int offline(int price) {
		return (int)(price - (price * (OFFLINE_PAYMENT_RATIO+cardRatio)));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제 시 총 할인율 : " + (ONLINE_PAYMENT_RATIO+cardRatio));
		System.out.println("오프라인 결제 시 총 할인율 : " + (OFFLINE_PAYMENT_RATIO+cardRatio));
		
	}

}
