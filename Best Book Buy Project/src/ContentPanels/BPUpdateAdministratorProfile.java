package ContentPanels;


public class BPUpdateAdministratorProfile extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUpdateAdministratorProfile() {
		super();
		
		String[] stateList = {"AL", "MI", "HI" };
		
		this.addLabelLabel("Username:", "<Username>");
		this.addLabelLabel("Date of Hire:", "<MM/DD/YY>");
		this.addLabelField("New Pin", 6);
		this.addLabelField("Re-type PIN:", 6);
		this.addLabelField("First Name:", 25);
		this.addLabelField("Last Name:", 25);
		this.addLabelField("Address:", 25);
		this.addLabelField("City:", 25);
		this.addLabelCombo("State:", stateList);
		this.addLabelField("ZIP:", 10);
		// this.SpecialStuff
		this.addButton("More Phone Nums");
		this.addButton("Fewer Phone Nums");
		
		this.addButton("Update");
		this.addButton("Cancel");


	}
}
