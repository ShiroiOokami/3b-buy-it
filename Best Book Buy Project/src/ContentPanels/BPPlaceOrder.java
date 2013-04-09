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
import Main.OrderSummary;
import Main.ShoppingCart;
import Main.User;

public class BPPlaceOrder extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrderSummary summary;

	public BPPlaceOrder(JFrame frame, OrderSummary sum) {
		super(frame);

		summary = sum;
		addLabel("                              Order Summary                    ");
		add(new CustomerInfo(frame));
		add(new ShowUserInfo(frame));

		ArrayList<Book> cartlist = summary.cart.getBooksInCart();
		OrderInfo[] o = new OrderInfo[cartlist.size()];
		for (int i = 0; i < cartlist.size(); i++)
			o[i] = new OrderInfo(frame,cartlist.get(i));
		if (cartlist.size() == 0)
			addLabel("No Items In Cart (wtf?)");
		else
			add(createScrollWrapper(o));

		addButton("Print");
		addButton("Ship Order");
		addButton("Cancel");

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

			User user = summary.user;
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

			User user = summary.user;
			JComponent[] comps = new JComponent[] {
					createLabel("UserID: " + user.getUserName()),
					createLabel("Date: " + summary.curDate()),
					createLabel("Time: " + summary.curTime()),
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

	private class OrderInfo extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Book book;
		private OrderInfo(JFrame frame, Book b) {
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
					" Qty: " + summary.cart.getQty(book) + " " +
					summary.cart.getBookSubtotalString(book));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void placeOrder()
	{
		//TODO: Update database here
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		case "Ship Order":
			placeOrder();
			parentFrame.switchDisplayContents(
					new BPViewOrders(parentFrame));
			break;
		case "Print":
			// Do Other Stuff
			break;			
		}
	}
}
