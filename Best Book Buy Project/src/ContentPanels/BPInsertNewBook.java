package ContentPanels;


public class BPInsertNewBook extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPInsertNewBook() {
		super();
		
		String categories[] = { "Bad", "Very Bad", "Pulp Pulp", "Horror" };
		this.addLabelField("ISBN:", 15);
		this.addLabelField("Title:", 20);
		//this.SpecialStuff
		this.addButton("More Authors");
		this.addButton("Fewer Authors");
		this.addLabelField("Publisher:", 20);
		this.addLabelField("Year:", 6);
		this.addLabelCombo("Category", categories);
		this.addLabelField("Price:", 8);
		this.addLabelField("Min. Qty. Req. In Stock:", 3);
		this.addLabel("Reviews:");

		this.addTextBox();
		this.addButton("More Reviews");
		this.addButton("Fewer Reviews");
		
		this.addButton("Insert");
		this.addButton("Cancel");
	}

}
