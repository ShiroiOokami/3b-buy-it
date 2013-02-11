package ContentPanels;

import java.awt.FlowLayout;


public class BPLandingPage extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPLandingPage() {
		super();
		FlowLayout l = (FlowLayout) this.getLayout();
		l.setAlignment(FlowLayout.CENTER);
		String selection[] = {"Search Only", "New Customer", "Returning Customer",
				"Administrator" };
		this.addLabel("                    Best Book Buy (3-B.com)                    ");
		this.addLabel("                    Online Bookstore                    ");
		this.addCombo(selection);
		
		this.addButton("Enter");
	}
}
