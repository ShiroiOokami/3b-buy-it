package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import Main.USState;


public class BPUpdateAdministratorProfile extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUpdateAdministratorProfile(JFrame frame) {
		super(frame);
		
		this.addLabelLabel("Username:", "<Username>");
		this.addLabelLabel("Date of Hire:", "<MM/DD/YY>");
		this.addLabelField("New Pin", 6);
		this.addLabelField("Re-type PIN:", 6);
		this.addLabelField("First Name:", 25);
		this.addLabelField("Last Name:", 25);
		this.addLabelField("Address:", 25);
		this.addLabelField("City:", 25);
		this.addLabelCombo("State:",
				stringList(USState.class));
		this.addLabelField("ZIP:", 10);
		// this.SpecialStuff
		this.addButton("More Phone Nums");
		this.addButton("Fewer Phone Nums");
		
		this.addButton("Update");
		this.addButton("Cancel");


	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "More Phone Nums":
			// More Ways To Disrupt My Evening
			break;
		case "Fewer Phone Nums":
			// You Get it
			break;
		case "Update":
			// Do Stuff
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		}		
	}
}
