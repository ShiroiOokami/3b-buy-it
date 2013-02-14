package Main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import ContentPanels.*;


public class BestBookBuy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main (String args[])
	{
		BestBookBuy b = new BestBookBuy();
		b.setVisible(true);
	}

	private BBBPanel currentPanel;
	private User user;
	
	public BestBookBuy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLocation(10, 10);
		setResizable(false);
		setSize(new Dimension(450, 450));
		setTitle("Main");
		setLayout(new FlowLayout());

		currentPanel = new BPLandingPage(this);
//			BBBPanel b2 = new BPBookSearch();
//			BBBPanel b3 = new BPBookSearchResult();
//			BBBPanel b4 = new BPDisplayReviews();
//			BBBPanel b5 = new BPShoppingCart();
//			BBBPanel b6 = new BPCustomerRegistration();
//			BBBPanel b7 = new BPCheckoutScreen();
//			BBBPanel b8 = new BPUpdateCustomer();
//			BBBPanel b9 = new BPProofOfPurchase();
//			BBBPanel c1 = new BPUserLogin();
//			BBBPanel c2 = new BPAdministratorTask();
//			BBBPanel c3 = new BPManageBookstoreCatalog();
//			BBBPanel c4 = new BPInsertNewBook();
//			BBBPanel c4_12 = new BPSearchForBooksToModify();
//			BBBPanel c5 = new BPSelectBooksForModification();
//			BBBPanel c6 = new BPUpdateBook();
//			BBBPanel c7 = new BPUpdateAdministratorProfile();
		
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
