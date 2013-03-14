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
	
	private boolean checkInputs()
	{
		boolean pass = true;
		if (pass = pass && UserRegExps.username(userName.getText()))
			System.out.println("Failed Username");
		if (pass = pass && UserRegExps.PIN(PIN.getText()))
			System.out.println("Failed PIN");
		if (pass = pass && UserRegExps.PIN(retypePIN.getText()))
			System.out.println("Failed RetypePIN");
		if (pass = pass && UserRegExps.name(firstName.getText()))
			System.out.println("Failed First Name");
		if (pass = pass && UserRegExps.name(lastName.getText()))
			System.out.println("Failed Last Name");
		if (pass = pass && UserRegExps.streetAdd(address.getText()))
			System.out.println("Failed Streed Add");
		if (pass = pass && UserRegExps.city(city.getText()))
			System.out.println("Failed City");

		return pass;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		case "Register":
			if (checkInputs())
				parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		}
	}
}
