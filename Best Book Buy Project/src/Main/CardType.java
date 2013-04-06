package Main;

public enum CardType {
	MasterCard("MasterCard"),
	VISA("VISA"),
	Paypal("Paypal");
	
	private String name;
	
	private CardType(String t) {
		name = t;
	}
	
	public String getName() {
		return name;
	}
}
