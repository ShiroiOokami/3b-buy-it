package ContentPanels;


public class BPUpdateBook extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUpdateBook() {
		super();
		
		String categories[] = { "Bad", "Very Bad", "Pulp Pulp", "Horror" };
		this.addLabelLabel("ISBN:", "<ISBN>");
		this.addLabelLabel("Status", "<Active/Deleted>");
		this.addLabelField("Title:", 10);
		//this.SpecialStuff
		this.addButton("More Authors");
		this.addButton("Fewer Authors");

		this.addLabelField("Publisher:", 20);
		this.addLabelField("Year:", 5);
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
