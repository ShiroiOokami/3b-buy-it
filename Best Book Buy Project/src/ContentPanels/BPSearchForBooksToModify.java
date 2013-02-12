package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;


public class BPSearchForBooksToModify extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPSearchForBooksToModify(JFrame frame) {
		super(frame);
		
		String categories[] = { "Bad", "Very Bad", "Pulp Pulp", "Horror" };
		
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		this.addLabelField("Search For:");
		this.addLabelCombo("Search In:", attributes);
		this.addLabelCombo("Category", categories);
		
		this.addButton("Search");
		this.addButton("Cancel");
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Search":
			parentFrame.switchDisplayContents(
					new BPSelectBooksForModification(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}
}
