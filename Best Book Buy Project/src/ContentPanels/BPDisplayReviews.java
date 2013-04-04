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
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import Main.Book;

public class BPDisplayReviews extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Book> booklist;
	private Book book;
	
	public BPDisplayReviews(JFrame frame, ArrayList<Book> bl, Book b) {
		super(frame);
		
		booklist = bl;
		book = b;
		
		addLabel("Reviews For: " + book.getTitle());
		addLabel("By: " + book.getAuthorString());
		
		DisplayReview[] j = new DisplayReview[book.getReviews().size()];
		for (int i = 0; i < book.getReviews().size(); i++)
			j[i] = new DisplayReview(frame, book.getReviews().get(i));
		if (book.getReviews().size() == 0)
			add(createLabel("No Reviews For This Book"));
		else
			add(createScrollWrapper(j));
		addButton("Done");
	}
	
	private class DisplayReview extends BBBPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private DisplayReview(JFrame frame, String review) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 12);
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout());
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			JTextArea a = addTextBox();
			a.setText(review);
			Dimension d = new Dimension(a.getPreferredSize());
			d.setSize(d.getWidth() + 20, d.getHeight() + 20);
			this.setPreferredSize(d);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Done":
			parentFrame.switchDisplayContents(
					new BPBookSearchResult(parentFrame, booklist));
			break;

		}
	}
}
