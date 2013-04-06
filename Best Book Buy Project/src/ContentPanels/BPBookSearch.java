package ContentPanels;

import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Main.Subject;
import Main.Book;

public class BPBookSearch extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	JTextField searchField;
	public BPBookSearch(JFrame frame) {
		super(frame);
		
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		searchField = addLabelField("Search For:", 10);
		addButton("Search");
		addLabelCombo("Search In: ", attributes);
		addLabelCombo("Category: ",
				stringList(Subject.class));
		addButton("Manage Shopping Cart");
		addButton("Exit");

	}
	
	public ArrayList<Book> performSearch()
	{
		HashSet<String> list = new HashSet<String>();
		String stext = searchField.getText();
		
		ArrayList<Book> b = new ArrayList<Book>();
		return b;
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
					new BPBookSearchResult(parentFrame, performSearch()));
			break;
		case "Manage Shopping Cart":
			parentFrame.switchDisplayContents(
					new BPShoppingCart(parentFrame));
			break;
		}
	}
}
