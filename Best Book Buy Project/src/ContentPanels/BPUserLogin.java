package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class BPUserLogin extends BBBPanel {

	JTextField username;
	JTextField pin;
	
	public BPUserLogin (JFrame frame) {
		super(frame);
		
		username = addLabelField("Username:", 12);
		pin = addLabelField("PIN:", 5);
		
		JComponent[] comps = new JComponent[] {
			createButton("Login"),
			createButton("Cancel")
		};
		
		add(createHorizontalWrapper(comps));
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
