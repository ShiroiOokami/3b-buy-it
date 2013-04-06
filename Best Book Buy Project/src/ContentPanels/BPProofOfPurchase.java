package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

import Main.Book;
import Main.User;

public class BPProofOfPurchase extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPProofOfPurchase(JFrame frame) {
		super(frame);

		addLabel("                              Proof of Purchase                    ");
		add(new CustomerInfo(frame));
		add(new ShowUserInfo(frame));

		ArrayList<Book> cartlist = parentFrame.cart.getBooksInCart();
		OrderSummary[] o = new OrderSummary[cartlist.size()];
		for (int i = 0; i < cartlist.size(); i++)
			o[i] = new OrderSummary(frame,cartlist.get(i));
		if (cartlist.size() == 0)
			addLabel("No Items In Cart (wtf?)");
		else
			add(createScrollWrapper(o));

		addLabel("Shipping Notice: The book will be here in 5 business days");
		addLabel("Subtotal: " + parentFrame.cart.getCartSubtotalString());
		addLabel("S&H: " + "5.00");
		addLabel("Total: " + (parentFrame.cart.getCartSubtotal() + 5));

		addButton("Print");
		addButton("New Search");
		addButton("Exit");

	}

	private class CustomerInfo extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private CustomerInfo(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 9);
			setPreferredSize(new Dimension(150, 100));
			setBackground(Color.WHITE);
			setLayout(new GridLayout(5, 1));
			setBorder(BorderFactory
					.createEtchedBorder(EtchedBorder.LOWERED));

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

	private class ShowUserInfo extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private ShowUserInfo(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 10);
			this.setPreferredSize(new Dimension(175, 100));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));

			User user = parentFrame.user;
			JComponent[] comps = new JComponent[] {
					createLabel("UserID: " + user.getUserName()),
					createLabel("Date: " + parentFrame.getCurDate()),
					createLabel("Time: " + parentFrame.getCurTime()),
					createLabel("Credit Card Information"),
					createLabel(user.getCardType().toString() + " - " +
							user.getCardNum())
			};
			add(createVerticalWrapper(comps));
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
			setPreferredSize(new Dimension(350, 60));
			setBackground(Color.WHITE);
			setLayout(new GridLayout(3, 1));
			setBorder(BorderFactory
					.createEtchedBorder(EtchedBorder.LOWERED));

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
		case "Exit":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		case "New Search":
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		case "Print":
			// Do Other Stuff
			break;			
		}
	}
}
