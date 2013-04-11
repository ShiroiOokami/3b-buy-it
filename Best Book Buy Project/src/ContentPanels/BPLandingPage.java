package ContentPanels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import Main.BestBookBuy;
import Main.ShoppingCart;
import Main.User;

/*
 * This is the top page, first shown to the user when they start the program.
 * It contains options for searching and adding to the cart without creating
 * a user. For registering as a new user. And for logging on as either an
 * admin or a customer.
 * 
 * The user is considered "logged off" on this page, and user and shopping
 * cart information is deleted at this point.
 */
public class BPLandingPage extends BBBPanel {

	private static final long serialVersionUID = 1L;

	public BPLandingPage(BestBookBuy frame) {
		super(frame);
		FlowLayout l = (FlowLayout) this.getLayout();
		l.setAlignment(FlowLayout.CENTER);
		addLabel("                          Best Book Buy (3-B.com)                       ");
		addLabel("                             Online Bookstore                          ");
		JComponent[] j = new JComponent[] {
				createButton("New Search"),
				createButton("Register"),
				createButton("Login")
		};
		
		add(createVerticalWrapper(j));
		parentFrame.user = new User();
		parentFrame.cart = new ShoppingCart();
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "New Search":
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		case "Register":
			parentFrame.switchDisplayContents(
					new BPCustomerRegistration(parentFrame));
			break;
		case "Login":
			parentFrame.switchDisplayContents(
					new BPUserLogin(parentFrame));
			break;
		default:
		}
	}
}
