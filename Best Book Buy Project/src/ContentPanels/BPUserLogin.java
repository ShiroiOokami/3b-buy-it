package ContentPanels;


public class BPUserLogin extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUserLogin () {
		super();
		
		this.addLabelField("Username:", 20);
		this.addLabelField("PIN:", 5);
		
		this.addButton("Login");
		this.addButton("Cancel");
	}
}
