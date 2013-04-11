package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

/*
 * This page is for managing the book store catalog. It only allows the admin
 * to select the way they will manage it and then take them to the appropriate
 * page.
 */
public class BPManageBookstoreCatalog extends BBBPanel {
	private static final long serialVersionUID = 1L;

	public BPManageBookstoreCatalog(JFrame frame) {
		super(frame);
		this.addButton("Insert New Book");
		this.addButton("Modify/Delete Book");
		this.addButton("Cancel");
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Insert New Book":
			parentFrame.switchDisplayContents(
					new BPInsertNewBook(parentFrame));
			break;
		case "Modify/Delete Book":
			parentFrame.switchDisplayContents(
					new BPSearchForBooksToModify(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		}		
	}
}
