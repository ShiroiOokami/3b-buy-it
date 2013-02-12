package ContentPanels;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class BPUserLogin extends BBBPanel {

	public BPUserLogin (JFrame frame) {
		super(frame);
		
		this.addLabelField("Username:", 20);
		this.addLabelField("PIN:", 5);
		
		this.addButton("Login");
		this.addButton("Cancel");
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Login":
			// Or Into BPBookSearch if User
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		}
	}
}
