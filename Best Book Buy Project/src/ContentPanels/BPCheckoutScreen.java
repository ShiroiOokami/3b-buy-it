package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import Main.Book;
import Main.CardType;
import Main.User;


public class BPCheckoutScreen extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox cardType;
	JTextField cardNum;
	JTextField cardDate;

	public BPCheckoutScreen(JFrame frame) {
		super(frame);
		
		addLabel("                    Confirm Order                    ");
		add(new CustomerInfo(frame));
		add(new AskForCardBox(frame));

		ArrayList<Book> cartlist = parentFrame.cart.getBooksInCart();
		OrderSummary[] o = new OrderSummary[cartlist.size()];
		for (int i = 0; i < cartlist.size(); i++)
			o[i] = new OrderSummary(frame,cartlist.get(i));
		if (cartlist.size() == 0)
			addLabel("No Items In Cart");
		else
			add(createScrollWrapper(o));

		addLabel("Shipping Notice: The book will be here in 5 business days");
		addLabel("Subtotal: " + parentFrame.cart.getCartSubtotalString());
		addLabel("S&H: " + "5.00");
		addLabel("Total: " + (parentFrame.cart.getCartSubtotal() + 5));
		
		JButton but;
		JComponent[] buts = new JComponent[] {
				createButton("New Search"),
				createButton("Update Profile"),
				but = createButton("BUY IT!!!!!!")
		};
		if (cartlist.size() == 0)
			but.setEnabled(false);
		add(createHorizontalWrapper(buts));
	}
	
	private class CustomerInfo extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private CustomerInfo(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 9);
			this.setPreferredSize(new Dimension(200,100));
			this.setBackground(Color.WHITE);
			this.setLayout(new GridLayout(5,1));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			User user = parentFrame.user;
			addLabel("Shipping Address:");
			addLabel(user.getFirstName() + " " +  user.getLastName());
			addLabel(user.getAddress());
			addLabel(user.getCity());
			addLabel(user.getState().getCode() + ", " + user.getZIP());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class AskForCardBox extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private AskForCardBox(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 12);
			setPreferredSize(new Dimension(150,100));
			setBackground(Color.WHITE);
			setLayout(new FlowLayout(FlowLayout.CENTER));
			//this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			cardType = addCombo(stringList(CardType.class));
			cardNum = addField(10);
			cardDate = addField(10);
			
			User user = parentFrame.user;
			cardType.setSelectedIndex(user.getCardType().ordinal());
			cardNum.setText(user.getCardNum());
			cardDate.setText(user.getExpDate());			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
		
	private class OrderSummary extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Book book;
		private OrderSummary(JFrame frame, Book b) {
			super(frame);
			book = b;
			font = new Font("Verdana", Font.BOLD, 12);
			setPreferredSize(new Dimension(350,60));
			setBackground(Color.WHITE);
			setLayout(new GridLayout(3, 1));
			setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			addLabel(book.getTitle());
			addLabel("By: " + book.getAuthorString());
			addLabel("Price: " + book.getPrice() +
					" Qty: " + parentFrame.cart.getQty(book) + " " +
					parentFrame.cart.getBookSubtotalString(book));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "New Search":
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		case "Update Profile":
			if (parentFrame.user.checkUserName())
				parentFrame.switchDisplayContents(
						new BPUpdateCustomer(parentFrame));
			else
				parentFrame.switchDisplayContents(
						new BPCustomerRegistration(parentFrame));
			break;
		case "BUY IT!!!!!!":
			parentFrame.switchDisplayContents(
					new BPProofOfPurchase(parentFrame));
			break;			
		}
	}
}
