package ContentPanels;


public class BPBookSearch extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPBookSearch() {
		super();
		
		String categories[] = { "Adventure", 
				"Bad", "Very Bad", "Pulp Pulp", "Horror" };
		
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		this.addLabelField("Search For:", 10);
		this.addButton("Search");
		this.addLabelCombo("Search In: ", attributes);
		this.addLabelCombo("Category: ", categories);
		
		this.addButton("Manage Shopping Cart");
		this.addButton("Exit 3-B.com");

	}
}
