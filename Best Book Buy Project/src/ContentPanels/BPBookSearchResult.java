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
import javax.swing.border.EtchedBorder;

import Main.Book;
/*
 * This page allows the user to search for books to purchase.
 * Using any category will search in all categories, and searching for
 * keyword anywhere will search all other selectable fields.
 */
public class BPBookSearchResult extends BBBPanel {

	private static final long serialVersionUID = 1L;

private ArrayList<Book> booklist;
private JLabel shopLabel;

	public BPBookSearchResult(JFrame frame, ArrayList<Book> arrayList) {
		super(frame);
		
		booklist = arrayList;
		shopLabel = createLabel("Your Shopping Cart Has " + parentFrame.cart.sizeOfCart()
				+ " items");
		add(shopLabel);
		addButton("Shopping Cart");
		SearchResults[] j = new SearchResults[booklist.size()];
		for (int i = 0; i < booklist.size(); i++)
			j[i] = new SearchResults(frame, booklist.get(i));
		if (!booklist.isEmpty())
			add(createScrollWrapper(j));
		else
			addLabel("No Books Found in Search");
		addButton("Checkout");
		addButton("New Search");
		addButton("Exit");
	}
	
	private void updateText() {
		shopLabel.setText("Your Shopping Cart Has " + parentFrame.cart.sizeOfCart()
				+ " items");
	}
	
	private class SearchResults extends BBBPanel {
		
		private static final long serialVersionUID = 1L;

		Book book;
		JButton addToCart;
		JLabel qty;
		public SearchResults(JFrame frame, Book b) {
			super(frame);
			book = b;
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,120));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			JComponent[] comps = new JComponent[] {
					qty = createLabel(""),
					addToCart = createButton("Add to Cart"),
					createButton("Reviews")
			};
			if (book.getCurQty().equals("0"))
			{
				addToCart.setEnabled(false);
				qty.setText("Out of Stock");
				qty.setForeground(Color.RED);
			}
			add(createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					createLabel("Title: " + book.getTitle()),
					createLabel("Author: " + book.getAuthorString()),
					createLabel("Publisher: " + book.getPulisher()),
					createLabel("ISBN: " + book.getISBN()),
					createLabel("Price: " + book.getPrice())
			};
			add(createVerticalWrapper(comps2));
			
			if (parentFrame.cart.getQty(book) > 0)
				addToCart.setEnabled(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand())
			{
			case "Add to Cart":
				parentFrame.cart.addBook(book);
				addToCart.setEnabled(false);
				updateText();
				break;
			case "Reviews":
				parentFrame.switchDisplayContents(
						new BPDisplayReviews(parentFrame, booklist, book));
				break;
			}
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
		case "Checkout":
			parentFrame.switchDisplayContents(
					new BPCheckoutScreen(parentFrame));
			break;
		case "Shopping Cart":
			parentFrame.switchDisplayContents(
				new BPShoppingCart(parentFrame));
			break;			
		}
	}
}
