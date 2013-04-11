package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import ContentPanels.*;

/**
 * Contains the main method that displays the
 * landing page and starts the program running.
 * 
 * @version 2013-04-11
 *
 */
public class BestBookBuy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main (String args[])
	{
		BBBConnection con = new BBBConnection();
		BestBookBuy b = new BestBookBuy();
		con.connect();
		b.setVisible(true);
	}

	private BBBPanel currentPanel;
	public User user;
	public ShoppingCart cart;
	
	public BestBookBuy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLocation(10, 10);
		setResizable(false);
		setSize(new Dimension(450, 450));
		setTitle("Main");
		setLayout(new FlowLayout());

		currentPanel = new BPLandingPage(this);
		user = new User();
		cart = new ShoppingCart();
		
		this.add(currentPanel);
		pack();
	}
	
	public void switchDisplayContents(BBBPanel p) {
		remove(currentPanel);
		currentPanel = p;
		add(p);
		pack();
	}
}
