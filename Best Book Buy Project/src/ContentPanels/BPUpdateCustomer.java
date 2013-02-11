package ContentPanels;


public class BPUpdateCustomer extends BBBPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUpdateCustomer() {
		super();
		
		String[] stateList = {"AL", "MI", "HI" };
		String[] cardList = { "CreditMaster", "Paypal", "Give Us Cash" };

		
		this.addLabelLabel("               Username:", "<Username>               ");
		this.addLabelField("New Pin", 5);
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
		
		this.addButton("Update");
		this.addButton("Cancel");
	}

}