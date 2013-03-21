package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

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

	public void setUserName(JTextField f) {
		userName = f.getText();
		if (checkUserName())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setFirstName(JTextField f) {
		fName = f.getText();
		if (checkFirstName())
			unsetWarning(f);
		else
			setWarning(f);			
	}

	public void setLastName(JTextField f) {
		lName = f.getText();
		if (checkLastName())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setPIN(JTextField f) {
		pin = f.getText();
		if(checkPIN())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setAddress(JTextField f) {
		address = f.getText();
		if (checkAddress())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setCity(JTextField f) {
		city = f.getText();
		if (checkCity())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setState(USState s) {
		state = s;
	}

	public void setZIP(JTextField f) {
		zip = f.getText();
		if (checkZIP())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setCardType(CardType c) {
		cardType = c;
	}

	public void setCardNum(JTextField f) {
		cardNum = f.getText().replaceAll("[-]", "");
		if (checkCardNum())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setExpDate(JTextField f) {
		expDate = f.getText();
		if (checkExpDate())
			unsetWarning(f);
		else
			setWarning(f);
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


	private void unsetWarning(JTextField f) {
		f.setForeground(Color.BLACK);
	}

	private void setWarning(JTextField f) {
		f.setForeground(Color.RED);
	}
}
