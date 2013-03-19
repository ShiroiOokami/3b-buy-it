package ContentPanels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import Main.BestBookBuy;
import Main.User;


public class BPLandingPage extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selection[] = {"Search Only", "New Customer", "Returning Customer",
	"Administrator" };
	private JComboBox<String> box;

	public BPLandingPage(BestBookBuy frame) {
		super(frame);
		FlowLayout l = (FlowLayout) this.getLayout();
		l.setAlignment(FlowLayout.CENTER);
		addLabel("                    Best Book Buy (3-B.com)                    ");
		addLabel("                    Online Bookstore                    ");
		box = addCombo(selection);
		
		addButton("Enter");
		parentFrame.user = new User();
	}

	public void actionPerformed(ActionEvent e) {
		if (!e.getActionCommand().equals("Enter"))
			return;
		
		switch (box.getSelectedIndex()) {
		case 0:
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		case 1:
			parentFrame.switchDisplayContents(
					new BPCustomerRegistration(parentFrame));
			break;
		case 2:
			parentFrame.switchDisplayContents(
					new BPUserLogin(parentFrame));
			break;
		case 3:
			parentFrame.switchDisplayContents(
					new BPUserLogin(parentFrame));
			break;
		default:
		}
	}
}
