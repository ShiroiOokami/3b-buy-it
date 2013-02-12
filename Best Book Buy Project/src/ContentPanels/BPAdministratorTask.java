package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;


public class BPAdministratorTask extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<String> box;
	
	public BPAdministratorTask(JFrame frame) {
		super(frame);
		
		String[] sel = {"Manage Bookstore Catalog", 
				"Place Orders", 
				"Generate Reports",
				"Update Admin Profile" };
		box = addLabelCombo("Administrator Tasks:", sel);
		addButton("Proceed");
		addButton("Exit");


	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit"))
		{
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			return;
		}

		if (!e.getActionCommand().equals("Proceed"))
		{
			return;
		}
		
		switch (box.getSelectedIndex()) {
		case 0:
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		case 1:
			// We'll Do that Later
			break;
		case 2:
			// Do More Stuff Later
			break;
		case 3:
			parentFrame.switchDisplayContents(
					new BPUpdateAdministratorProfile(parentFrame));
			break;
		default:
		}
	}
}
