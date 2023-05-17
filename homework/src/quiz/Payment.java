package quiz;

public interface Payment {
	//상수필드
	public static final double ONLINE_PAYMENT_RATIO = 0.05;
	public static final double OFFLINE_PAYMENT_RATIO = 0.03;
	
	
	//추상메소드
	public int online(int price);
	public int offline(int price);
	public void showInfo();
	
}
