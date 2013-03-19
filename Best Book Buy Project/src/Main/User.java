package Main;

public class User {
	private String userName;
	private String fName;
	private String lName;
	private String pin;
	private String address;
	private String city;
	private USState state;
	private String zip;
	private CardType cardType;
	private String cardNum;
	private String expDate;

	public User() {
		userName = "<User Login>";
		fName = "<First Name>";
		lName = "<Last Name>";
		pin = "<PIN>";
		address = "<Address>";
		city = "<City>";
		state = USState.AL;
		zip = "<ZIP>";
		cardType = CardType.MasterCard;
		cardNum = "<Card Number>";
		expDate = "<Exp Date>";
	}

	public String getUserName() {
		return userName;
	}
	
	public boolean checkUserName() {
		return UserRegExps.username(userName);
	}

	public String getFirstName() {
		return fName;
	}
	
	public boolean checkFirstName() {
		return UserRegExps.name(fName);
	}

	public String getLastName() {
		return lName;
	}

	public boolean checkLastName() {
		return UserRegExps.name(lName);
	}

	public String getPIN() {
		return pin;
	}
	
	public boolean checkPIN() {
		return UserRegExps.PIN(pin);
	}

	public String getAddress() {
		return address;
	}

	public boolean checkAddress() {
		return UserRegExps.streetAdd(address);
	}

	public String getCity() {
		return city;
	}
	
	public boolean checkCity() {
		return UserRegExps.city(city);
	}

	public USState getState() {
		return state;
	}
	
	public boolean checkState() {
		return state != null;
	}

	public String getZIP() {
		return zip;
	}
	
	public boolean checkZIP() {
		return UserRegExps.ZIP(zip);
	}

	public CardType getCardType() {
		return cardType;
	}
	
	public boolean checkCardType() {
		return cardType != null;
	}

	public String getCardNum() {
		return cardNum;
	}
	
	public boolean checkCardNum() {
		return UserRegExps.cardnum(cardNum);
	}

	public String getExpDate() {
		return expDate;
	}
	
	public boolean checkExpDate() {
		return UserRegExps.carddate(expDate);
	}

	public boolean setUserName(String s) {
		userName = s;
		return checkUserName();
	}

	public boolean setFirstName(String s) {
		fName = s;
		return checkFirstName();
	}

	public boolean setLastName(String s) {
		lName = s;
		return checkLastName();
	}

	public boolean setPIN(String p) {
		pin = p;
		return checkPIN();
	}

	public boolean setAddress(String s) {
		address = s;
		return checkAddress();
	}

	public boolean setCity(String s) {
		city = s;
		return checkCity();
	}

	public boolean setState(USState s) {
		state = s;
		return checkState();
	}

	public boolean setZIP(String z) {
		zip = z;
		return checkZIP();
	}

	public boolean setCardType(CardType c) {
		cardType = c;
		return checkCardType();
	}

	public boolean setCardNum(String n) {
		cardNum = n.replaceAll("[-]", "");
		return checkCardNum();
	}

	public boolean setExpDate(String d) {
		expDate = d;
		return checkExpDate();
	}
	
	public boolean checkInputs()
	{
		boolean pass = true;
		
		pass &= checkUserName();
		pass &= checkPIN();
		pass &= checkFirstName();
		pass &= checkLastName();
		pass &= checkAddress();
		pass &= checkCity();
		pass &= checkState();
		pass &= checkZIP();
		pass &= checkCardType();
		pass &= checkCardNum();
		pass &= checkExpDate();

		return pass;
	}
}
