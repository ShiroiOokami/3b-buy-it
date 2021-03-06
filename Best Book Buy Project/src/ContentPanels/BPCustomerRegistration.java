package ContentPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Main.CardType;
import Main.USState;
import Main.User;

/*
 * This page allows the user to register their information. When a field is
 * entered incorrectly, red warning text will show the user where they typed
 * incorrectly.
 */
public class BPCustomerRegistration extends BBBPanel {

	private static final long serialVersionUID = 1L;

	private JTextField userName;
	private JTextField PIN;
	private JTextField retypePIN;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField city;
	private JTextField zip;
	private JComboBox<String> state;
	private JComboBox<String> cardType;
	private JTextField cardNum;
	private JTextField cardDate;
	private User user = parentFrame.user;
	
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
		
		JComponent[] buts = new JComponent[] {
				createButton("Register"),
				createButton("Login"),
				createButton("Cancel")
		};
		add(createHorizontalWrapper(buts));
	}
		
	private void feedUser()
	{	
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
				if(user.addCustomer())
				{
					parentFrame.switchDisplayContents(
							new BPBookSearch(parentFrame));
				}
				else
				{
					userName.setText("Username already in use");
					userName.setForeground(Color.RED);
				}
			break;
		case "Login":
			parentFrame.switchDisplayContents(
					new BPUserLogin(parentFrame));
			break;			
		}
	}
}
