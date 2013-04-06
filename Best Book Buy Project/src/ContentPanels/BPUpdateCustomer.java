package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Main.CardType;
import Main.USState;
import Main.User;


public class BPUpdateCustomer extends BBBPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private JTextField userName;
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
	
	private User user = parentFrame.user;

	public BPUpdateCustomer(JFrame frame) {
		super(frame);
		
		addLabelLabel("               Username:", 
				parentFrame.user.getUserName() + "                ");
		PIN = addLabelField("New Pin", 5);
		retypePIN = addLabelField("Re-type PIN:", 5);
		firstName = addLabelField("First Name:", 25);
		lastName = addLabelField("Last Name:", 25);
		address = addLabelField("Address:", 25);
		city = addLabelField("City:", 25);
		state = addLabelCombo("State:", stringList(USState.class));
		zip = addLabelField("ZIP:", 8);
		cardType = addLabelCombo("Credit Card:", stringList(CardType.class));
		cardNum = addLabelField("Card Number:", 18);
		cardDate = addLabelField("Expiration Date:", 10);
		
		eatUser();
		
		this.addButton("Update");
		this.addButton("Cancel");
	}
	
	private void feedUser()
	{
		User user = parentFrame.user;
		
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
	
	private void eatUser()
	{	
		firstName.setText(user.getFirstName());
		lastName.setText(user.getLastName());
		PIN.setText(user.getPIN());
		address.setText(user.getAddress());
		city.setText(user.getCity());
		zip.setText(user.getZIP());
		state.setSelectedIndex(user.getState().ordinal());
		cardType.setSelectedIndex(user.getCardType().ordinal());
		cardNum.setText(user.getCardNum());
		cardDate.setText(user.getExpDate());
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Update":
			feedUser();
			user.updateCustomer();
			
			if (parentFrame.user.checkCustomer())
				parentFrame.switchDisplayContents(
					new BPCheckoutScreen(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPCheckoutScreen(parentFrame));
			break;
		}
	}

}
