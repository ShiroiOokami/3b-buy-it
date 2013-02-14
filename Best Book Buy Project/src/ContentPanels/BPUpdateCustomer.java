package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import Main.CardType;
import Main.USState;


public class BPUpdateCustomer extends BBBPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUpdateCustomer(JFrame frame) {
		super(frame);
		
		this.addLabelLabel("               Username:", "<Username>               ");
		this.addLabelField("New Pin", 5);
		this.addLabelField("Re-type PIN:", 5);
		this.addLabelField("First Name:", 25);
		this.addLabelField("Last Name:", 25);
		this.addLabelField("Address:", 25);
		this.addLabelField("City:", 25);
		this.addLabelCombo("State:", 
				stringList(USState.class));
		this.addLabelField("ZIP:", 8);
		this.addLabelCombo("Credit Card:",
				stringList(CardType.class));
		this.addLabelField("Card Number:", 18);
		this.addLabelField("Expiration Date:", 10);
		
		this.addButton("Update");
		this.addButton("Cancel");
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Update":
			// Do More Stuff
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
