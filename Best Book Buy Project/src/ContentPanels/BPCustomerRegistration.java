package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Main.CardType;
import Main.USState;
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
	public BPCustomerRegistration(JFrame frame) {
		super(frame);
		
		//String[] stateList = {"AL", "MI", "HI" };
		//String[] cardList = { "CreditMaster", "Paypal", "Give Us Cash" };
		
		userName = addLabelField("User Name:", 20);
		PIN = addLabelField("PIN:", 5);
		retypePIN = addLabelField("Re-type PIN:", 5);
		firstName = addLabelField("First Name:", 25);
		lastName = addLabelField("Last Name:", 25);
		address = addLabelField("Address:", 25);
		city = addLabelField("City:", 25);
		addLabelCombo("State:", 
				stringList(USState.class));
		zip = addLabelField("ZIP:", 8);
		this.addLabelCombo("Credit Card:",
				stringList(CardType.class));
		this.addLabelField("Card Number:", 18);
		this.addLabelField("Expiration Date:", 10);
		
		this.addButton("Register");
		this.addButton("Cancel");
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		case "Register":
			System.out.println("Test UName: " +
		UserRegExps.username(userName.getText()));
			System.out.println("Test PIN: " +
		UserRegExps.PIN(PIN.getText()));
			System.out.println("Test PIN-R: " +
		UserRegExps.PIN(retypePIN.getText()));
			System.out.println("Test FName: " +
		UserRegExps.name(firstName.getText()));
			System.out.println("Test LName: " +
		UserRegExps.name(lastName.getText()));
			System.out.println("Test Add: " +
		UserRegExps.streetAdd(address.getText()));
			System.out.println("Test City: " +
		UserRegExps.city(city.getText()));

			//parentFrame.switchDisplayContents(
					//new BPBookSearch(parentFrame));
			break;

		}
	}
}
