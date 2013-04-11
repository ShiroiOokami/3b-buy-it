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
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import Main.Book;

/*
 * This page lets you select books for modify them, and also allows you to
 * toggle the deletion status. Deletion will prevent more of this book from
 * being ordered.
 */
public class BPSelectBooksForModification extends BBBPanel {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Book> booklist;
	public BPSelectBooksForModification(JFrame frame, ArrayList<Book> arrayList) {
		super(frame);
		
		booklist = arrayList;
		SearchResults[] j = new SearchResults[booklist.size()];
		for (int i = 0; i < booklist.size(); i++)
			j[i] = new SearchResults(frame, booklist.get(i));
		if (!booklist.isEmpty())
			add(createScrollWrapper(j));
		else
			addLabel("No Books Found in Search");

		addButton("Done");
	}
	
	private class SearchResults extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Book book;
		public JLabel deleted;
		public JLabel qty;
		
		public SearchResults(JFrame frame, Book b) {
			super(frame);
			book = b;
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,140));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			JComponent[] comps = new JComponent[] {
					qty = createLabel(""),
					createButton("Delete"),
					createButton("Update")
			};
			if (book.getCurQty().equals("0"))
			{
				qty.setText("Out of Stock");
				qty.setForeground(Color.RED);
			}
			add(createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					createLabel("Title: " + book.getTitle()),
					createLabel("Author: " + book.getAuthorString()),
					createLabel("Publisher: " + book.getPulisher()),
					createLabel("ISBN: " + book.getISBN()),
					createLabel("Price: " + book.getPrice()),
					deleted = createLabel(book.getDeleted().matches("Y") 
							? "Deleted" : "Active")
			};
			add(createVerticalWrapper(comps2));
		}

		public void toggleDeleted() {
			if (book.getDeleted().matches("Y"))
			{
				book.setDeleted("N");
				book.updateBook();
				deleted.setText("Active");				
			} else {
				book.setDeleted("Y");
				book.updateBook();
				deleted.setText("Deleted");				
			}
			// TODO: Stuff
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand())
			{
			case "Delete":
				toggleDeleted();
				break;
			case "Update":
				parentFrame.switchDisplayContents(
						new BPUpdateBook(parentFrame, booklist, book));
				break;
			}			
		}
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Done":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}
}
