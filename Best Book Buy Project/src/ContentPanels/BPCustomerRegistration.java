package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Main.CardType;
import Main.USState;
import Main.User;
import Main.UserRegExps;

public class BPCustomerRegistration extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField userName;
	private JTextField PIN;
	private JTextField retypePIN;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField city;
	private JTextField zip;
	private JComboBox state;
	private JComboBox cardType;
	private JTextField cardNum;
	private JTextField cardDate;
	
	public BPCustomerRegistration(JFrame frame) {
		super(frame);

		userName = addLabelField("User Name:", 20);
		PIN = addLabelField("PIN:", 5);
		retypePIN = addLabelField("Re-type PIN:", 5);
		firstName = addLabelField("First Name:", 25);
		lastName = addLabelField("Last Name:", 25);
		address = addLabelField("Address:", 25);
		city = addLabelField("City:", 25);
		state = addLabelCombo("State:", 
				stringList(USState.class));
		zip = addLabelField("ZIP:", 8);
		cardType = addLabelCombo("Credit Card:",
				stringList(CardType.class));
		cardNum = addLabelField("Card Number:", 18);
		cardDate = addLabelField("Expiration Date:", 10);
		
		this.addButton("Register");
		this.addButton("Cancel");
	}
		
	private void feedUser()
	{
		User user = parentFrame.user;
		
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPIN(PIN);
		user.setAddress(address);
		user.setCity(city);
		user.setZIP(zip);
		user.setState(USState.values()[state.getSelectedIndex()]);
		user.setCardType(CardType.values()[cardType.getSelectedIndex()]);
		user.setCardNum(cardNum);
		user.setExpDate(cardDate);
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		case "Register":
			feedUser();
			if (parentFrame.user.checkCustomer())
				parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		}
	}
}
