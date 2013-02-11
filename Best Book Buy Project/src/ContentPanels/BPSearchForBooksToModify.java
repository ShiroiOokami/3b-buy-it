package ContentPanels;


public class BPSearchForBooksToModify extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPSearchForBooksToModify() {
		super();
		
		String categories[] = { "Bad", "Very Bad", "Pulp Pulp", "Horror" };
		
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		this.addLabelField("Search For:");
		this.addLabelCombo("Search In:", attributes);
		this.addLabelCombo("Category", categories);
		
		this.addButton("Search");
		this.addButton("Cancel");
	}
}
