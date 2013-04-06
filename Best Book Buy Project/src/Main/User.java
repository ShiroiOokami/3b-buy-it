package Main;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	private String hireDate;
	private ArrayList<String> phoneNums;

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
		hireDate = "<Hire Date>";
		phoneNums = new ArrayList<String>();
		phoneNums.add("<Phone>");
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
		return UserRegExps.date(expDate);
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public boolean checkHireDate() {
		return UserRegExps.date(hireDate);
	}

	public void setUserName(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<User Name>");
		userName = f.getText();
		if (checkUserName())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setFirstName(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<First Name>");
		fName = f.getText();
		if (checkFirstName())
			unsetWarning(f);
		else
			setWarning(f);			
	}

	public void setLastName(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<Last Name>");
		lName = f.getText();
		if (checkLastName())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setPIN(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<PIN>");
		pin = f.getText();
		if(checkPIN())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setAddress(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<Address>");
		address = f.getText();
		if (checkAddress())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setCity(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<City>");
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
		if (f.getText().length() == 0)
			f.setText("<ZIP>");
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
		if (f.getText().length() == 0)
			f.setText("<Card Number>");
		cardNum = f.getText().replaceAll("[-]", "");
		if (checkCardNum())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setExpDate(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<Exp Date>");
		expDate = f.getText();
		if (checkExpDate())
			unsetWarning(f);
		else
			setWarning(f);
	}

	public void setHireDate(JTextField f) {
		if (f.getText().length() == 0)
			f.setText("<Hire Date>");
		expDate = f.getText();
		if (checkHireDate())
			unsetWarning(f);
		else
			setWarning(f);
	}
	
	public ArrayList<String> getPhoneNums() {
		return phoneNums;
	}
	
	public void setPhoneNum(ArrayList<String> p) {
		phoneNums = p;
	}
	
	public void removeLastNum(String s) {
		if (phoneNums.size() > 0)
			phoneNums.remove(phoneNums.size() - 1);
	}
	
	public void fetchUser(String username)
	{
		java.sql.Connection con = BBBConnection.getConnection();
		
		String userQuerry = "Select * from User where UserName Like '" + username + "'";
		String customerQuerry = "Select * from User natural join Customer where UserName Like '" + username + "'";
		String adminQuerry = "Select * from (User natural join Admin_Phone) natural join Admin where UserName like '" + username + "'";
		
		String querry = "Select * from User natural join Customer where UserName Like '" + username + "'";
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(userQuerry);
			
			rs.next();
			
			if(rs.getString("UserType").equals("C"))
			{
				rs = stmt.executeQuery(customerQuerry);
				
				while(rs.next())
				{
					this.userName = rs.getString("UserName");
					this.fName = rs.getString("fName");
					this.lName = rs.getString("lName");
					this.pin = rs.getString("PIN");
					this.address = rs.getString("StreetAdd");
					this.zip = rs.getString("Zip");
					String serverState = rs.getString("State");
					System.out.println(serverState);
					for (USState s : USState.values())
					{
						if(s.getCode().equalsIgnoreCase(serverState))
						{
							this.state = s;
						}
					}
					this.city = rs.getString("City");
					String serverType = rs.getString("creditType");
					for (CardType t : CardType.values())
					{
						if(t.getName().equalsIgnoreCase(serverType))
						{
							this.cardType = t;
						}
					}
					this.cardNum = rs.getString("creditNum");
					this.expDate = rs.getString("expDate");
				}
			}
			else
			{
				rs = stmt.executeQuery(adminQuerry);
				
				// Remove default number
				this.phoneNums.remove(0);
				
				while(rs.next())
				{
					this.userName = rs.getString("UserName");
					this.fName = rs.getString("fName");
					this.lName = rs.getString("lName");
					this.pin = rs.getString("PIN");
					this.address = rs.getString("StreetAdd");
					this.zip = rs.getString("Zip");
					//this.state = rs.getString("State");
					this.city = rs.getString("City");
					this.phoneNums.add(rs.getString("PhoneNum"));
					this.hireDate = rs.getString("HireDate");
				}
			}
			
			rs.close();
			
		}
		catch (SQLException error)
		{
			System.out.println("User Fetch Querry Error");
			error.printStackTrace();
		}
		
		
	}

	public boolean checkCustomer()
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

	public boolean checkAdmin()
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
		pass &= checkHireDate();

		return pass;
	}
	
	public boolean addCustomer ()
	{
		Connection con = BBBConnection.getConnection();
		
		String userQuerry = "Insert into User values (\"" + userName + "\", \"" + fName + "\", \"" + lName + "\"," + pin + ", \"" + address + "\", " + zip + ", \"" + state.getCode() + "\", \"" + city + "\", \"C\")";
		String customerQuerry = "Insert into Customer values (\"" + userName + "\", " + cardNum + ", \"" + cardType.toString() + "\", \"" + expDate + "\")";
			
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(userQuerry);
			stmt.executeUpdate(customerQuerry);
			return true;
		}
		catch (SQLException error)
		{
		//	System.out.println("User Insertion Querry Error");
		//	error.printStackTrace();
			return false;
		}
		
	}
	
	public boolean updateCustomer ()
	{
		Connection con = BBBConnection.getConnection();

		String userQuerry = "Update User Set fName=\"" + fName + "\", lName=\"" + lName + "\", PIN=" + pin + ", StreetAdd=\"" + address + "\", Zip=" + zip + ", State=\"" + state.getCode() + "\", City=\"" + city + "\" Where UserName Like \"" + userName + "\"";
		String customerQuerry = "Update Customer Set creditNum=" + cardNum + ", creditType=\"" + cardType.toString() + "\", expDate=\"" + expDate + "\" Where UserName Like \"" + userName + "\"";

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(userQuerry);
			stmt.executeUpdate(customerQuerry);
			return true;
		}
		catch (SQLException error)
		{
			System.out.println("User Insertion Querry Error");
			error.printStackTrace();
			return false;
		}
	}

	private void unsetWarning(JTextField f) {
		f.setForeground(Color.BLACK);
	}

	private void setWarning(JTextField f) {
		f.setForeground(Color.RED);
	}
	
	
}
