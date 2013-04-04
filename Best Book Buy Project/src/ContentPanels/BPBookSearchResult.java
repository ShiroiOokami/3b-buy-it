package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

import Main.Book;

public class BPBookSearchResult extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private ArrayList<Book> booklist;

	public BPBookSearchResult(JFrame frame, ArrayList<Book> arrayList) {
		super(frame);
		
		booklist = arrayList;
		arrayList.add(new Book());
		arrayList.add(new Book());
		arrayList.add(new Book());
		addLabel("Your Shopping Cart Has 6 items");
		addButton("Shopping Cart");
		SearchResults[] j = new SearchResults[booklist.size()];
		for (int i = 0; i < booklist.size(); i++)
			j[i] = new SearchResults(frame, booklist.get(i));
		add(createScrollWrapper(j));
		addButton("Checkout");
		addButton("New Search");
		addButton("Exit");
	}
	
	private class SearchResults extends BBBPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		Book book;
		public SearchResults(JFrame frame, Book b) {
			super(frame);
			book = b;
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,120));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			JComponent[] comps = new JComponent[] {
					createButton("Add to Cart"),
					createButton("Reviews")
			};
			add(createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					createLabel("Title: " + book.getTitle()),
					createLabel("Author: " + book.getAuthorString()),
					createLabel("Publisher: " + book.getPulisher()),
					createLabel("ISBN: " + book.getISBN()),
					createLabel("Price: " + book.getPrice())
			};
			add(createVerticalWrapper(comps2));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
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
