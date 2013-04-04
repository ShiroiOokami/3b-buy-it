package ContentPanels;

import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.JFrame;

import Main.Subject;
import Main.Book;

public class BPBookSearch extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPBookSearch(JFrame frame) {
		super(frame);
		
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		addLabelField("Search For:", 10);
		addButton("Search");
		addLabelCombo("Search In: ", attributes);
		addLabelCombo("Category: ",
				stringList(Subject.class));
		addButton("Manage Shopping Cart");
		addButton("Exit");

	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Exit":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		case "Search":
			parentFrame.switchDisplayContents(
					new BPBookSearchResult(parentFrame, new ArrayList<Book>()));
			break;
		case "Manage Shopping Cart":
			parentFrame.switchDisplayContents(
					new BPShoppingCart(parentFrame));
			break;
		}
	}
}
