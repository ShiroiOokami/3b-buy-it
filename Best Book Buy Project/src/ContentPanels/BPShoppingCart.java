package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import Main.Book;
import Main.BookRegExp;

public class BPShoppingCart extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ShopCartItem[] shoplist;
	private JLabel total;
	
	public BPShoppingCart(JFrame frame) {
		super(frame);
		
		addButton("Checkout");
		addButton("New Search");
		
		ArrayList<Book> inCart = parentFrame.cart.getBooksInCart();
		shoplist = new ShopCartItem[inCart.size()];
		for (int i = 0; i < inCart.size(); i++)
			shoplist[i] = new ShopCartItem(frame, inCart.get(i));
		if (inCart.size() > 0)
			add(createScrollWrapper(shoplist));
		else
			add(createLabel("Nothing in cart"));

		total = createLabel(
				"                                             Subtotal: " + 
				parentFrame.cart.getCartSubtotalString());
		add(total);
		addButton("Recalculate Total");
		
		addButton("Exit");
	}
	
	private class ShopCartItem extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Book book;
		public JButton btn;
		public JTextField qty;
		public JLabel subtot;
		
		private ShopCartItem(JFrame frame, Book b) {
			super(frame);
			book = b;
			font = new Font("Verdana", Font.BOLD, 12);
			setPreferredSize(new Dimension(350,75));
			setBackground(Color.WHITE);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			btn = createButton("Remove");
			add(btn);
			JComponent[] comps = new JComponent[] {
					createLabel(book.getTitle()),
					createLabel("By: " + book.getAuthorString()),
					createLabel("Price: " + book.getPrice())
			};
			add(createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					qty = createField(3),
					subtot = createLabel(
							parentFrame.cart.getBookSubtotalString(book))
			};
			qty.setText("" + parentFrame.cart.getQty(book));
			
			add(createVerticalWrapper(comps2));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand())
			{
			case "Remove":
				qty.setText("0");
				parentFrame.cart.removeBook(book);
				qty.setEnabled(false);
				btn.setEnabled(false);
				updateQty();
				break;
			}
		}
	}
	
	private void updateQty() {
		for (ShopCartItem sci : shoplist)
		{
			int qty;
			if (BookRegExp.qty(sci.qty.getText()))
				qty = Integer.parseInt(sci.qty.getText());
			else
				qty = 0;
			qty = Math.min(qty, Integer.parseInt(sci.book.getCurQty()));
			if (qty == 0)
				parentFrame.cart.removeBook(sci.book);
			else
				parentFrame.cart.setQty(sci.book, qty);
			
			sci.qty.setText("" + qty);
			sci.subtot.setText("" + 
					parentFrame.cart.getBookSubtotalString(sci.book));
		}
		total.setText(
				"                                             Subtotal: " + 
				parentFrame.cart.getCartSubtotalString());
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
		case "Recalculate Total":
			updateQty();
			break;
		case "Checkout":
			parentFrame.switchDisplayContents(
					new BPCheckoutScreen(parentFrame));
			break;
		}
	}
}
