package ContentPanels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * This page is shown once the administrator logs on, and allows him to select
 * various tasks. This page only takes the administrator to new pages.
 */
public class BPAdministratorTask extends BBBPanel {

	private static final long serialVersionUID = 1L;

	public BPAdministratorTask(JFrame frame) {
		super(frame);
		FlowLayout l = (FlowLayout) this.getLayout();
		l.setAlignment(FlowLayout.CENTER);
		JComponent[] j = new JComponent[] {
				createButton("Manage Catalog"),
				createButton("Place Orders"),
				createButton("Generate Reports"),
				createButton("Update Admin Profile"),
				createButton("Restock Inventory"),
				createButton("Exit")
		};
		
		add(createVerticalWrapper(j));
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Manage Catalog":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		case "Place Orders":
			parentFrame.switchDisplayContents(
					new BPViewOrders(parentFrame));
			break;
		case "Generate Reports":
			break;
		case "Update Admin Profile":
			parentFrame.switchDisplayContents(
					new BPUpdateAdministratorProfile(parentFrame));
			break;
		case "Restock Inventory":
			parentFrame.switchDisplayContents(
					new BPRestockInventory(parentFrame));
			break;
		case "Exit":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		}
	}
}
