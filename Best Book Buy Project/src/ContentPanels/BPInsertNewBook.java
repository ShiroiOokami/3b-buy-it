package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;


public class BPInsertNewBook extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPInsertNewBook(JFrame frame) {
		super(frame);
		
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
		case "Insert":
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
