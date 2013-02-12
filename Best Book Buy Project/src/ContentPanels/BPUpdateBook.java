package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;


public class BPUpdateBook extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPUpdateBook(JFrame frame) {
		super(frame);
		
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
		
		this.addButton("Update");
		this.addButton("Cancel");


	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "More Reviews":
			// Deceive Customers More
			break;
		case "Fewer Reviews":
			// Deceive Customers Less
			break;
		case "More Authors":
			// Pay Current Authors Less
			break;
		case "Fewer Authors":
			// Pay Current Authors More
			break;
		case "Update":
			// Do Stuff
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}
}
