package ContentPanels;


public class BPAdministratorTask extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPAdministratorTask() {
		super();
		
		String[] sel = {"Manage Bookstore Catalog", "Place Orders", "Generate Reports",
				"Update Admin Profile" };
		this.addLabelCombo("Administrator Tasks:", sel);
		this.addButton("Proceed");
		this.addButton("Exit");


	
	}
}
