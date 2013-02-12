package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

public class BPCustomerRegistration extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPCustomerRegistration(JFrame frame) {
		super(frame);
		
		String[] stateList = {"AL", "MI", "HI" };
		String[] cardList = { "CreditMaster", "Paypal", "Give Us Cash" };
		this.addLabelField("User Name:", 20);
		this.addLabelField("PIN:", 5);
		this.addLabelField("Re-type PIN:", 5);
		this.addLabelField("First Name:", 25);
		this.addLabelField("Last Name:", 25);
		this.addLabelField("Address:", 25);
		this.addLabelField("City:", 25);
		this.addLabelCombo("State:", stateList);
		this.addLabelField("ZIP:", 8);
		this.addLabelCombo("Credit Card:", cardList);
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
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;

		}
	}
}
