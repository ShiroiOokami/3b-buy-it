package Main;

/**
 * An enumerated type for all of the valid credit
 * cards the users can use.
 * 
 * @version 2013-04-11
 *
 */
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
