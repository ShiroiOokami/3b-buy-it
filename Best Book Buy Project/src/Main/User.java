package Main;

public class User {
	private String userName;
	private String fName;
	private String lName;
	private int pin;
	private String address;
	private String city;
	private USState state;
	private int zip;
	private CardType cardType;
	private int cardNum;
	private String expDate;

	public User() {
		userName = "<User Login>";
		fName = "<First Name>";
		lName = "<Last Name>";
		pin = 0;
		address = "<Address>";
		city = "<City>";
		state = USState.AL;
		zip = 0;
		cardType = CardType.MasterCard;
		cardNum = 0;
		expDate = "<Date>";
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public int getPIN() {
		return pin;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public USState getState() {
		return state;
	}

	public int getZIP() {
		return zip;
	}

	public CardType getCardType() {
		return cardType;
	}

	public int getCardNum() {
		return cardNum;
	}

	public String getExpDate() {
		return expDate;
	}
	
	
	public String setUserName(String s) {
		return userName = s;
	}

	public String setFirstName(String s) {
		return fName = s;
	}

	public String setLastName(String s) {
		return lName = s;
	}

	public int setPIN(int i) {
		return pin = i;
	}

	public String setAddress(String s) {
		return address = s;
	}

	public String setCity(String s) {
		return city = s;
	}

	public USState setState(USState s) {
		return state = s;
	}

	public int setZIP(int i) {
		return zip = i;
	}

	public CardType setCardType(CardType c) {
		return cardType = c;
	}

	public int setCardNum(int i) {
		return cardNum = i;
	}

	public String setExpDate(String d) {
		return expDate = d;
	}
}
