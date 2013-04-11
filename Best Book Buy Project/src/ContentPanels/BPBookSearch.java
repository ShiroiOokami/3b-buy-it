package ContentPanels;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Main.BBBConnection;
import Main.Subject;
import Main.Book;

/*
 * This page allows you to search for books to modify. It works exactly like
 * the one to search for books to modify by an admin.
 * Using any category will search in all categories, and searching for
 * keyword anywhere will search all other selectable fields.
 */
public class BPBookSearch extends BBBPanel {

	private static final long serialVersionUID = 1L;
	

	JComboBox<String> searchByBox;
	JTextField searchField;
	JComboBox<String> searchCategory;
	public BPBookSearch(JFrame frame) {
		super(frame);
		
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		searchField = addLabelField("Search For:", 10);
		addButton("Search");
		searchByBox = addLabelCombo("Search In: ", attributes);
		searchCategory = addLabelCombo("Category: ",
				stringList(Subject.class));
		addButton("Manage Shopping Cart");
		addButton("Exit");

	}
	
	public ArrayList<Book> performSearch()
	{
		HashSet<String> list = new HashSet<String>();
		String stext = searchField.getText();
		String query = "";
		switch((String) searchByBox.getSelectedItem())
		{
			case "Keyword Anywhere":
				query = "Select ISBN from Book natural join Book_Author where" +
					" (Title like '%" + stext +"%'" +
					" or Author like '%" + stext +"%'" +
					" or Publisher like '%" + stext +"%'" +
					" or ISBN like '%" + stext +"%')";
				break;
			case "Title":
				query = "Select ISBN from Book where (Title like '%" + 
							stext + "%')";
				break;
			case "Author":
				query = "Select ISBN from Book_Author where (Author like '%" + 
						stext + "%')";
				break;
			case "Publisher":
				query = "Select ISBN from Book where (Publisher like '%" + 
						stext + "%')";
				break;
			case "ISBN":
				query = "Select ISBN from Book where (ISBN like '%" + 
						stext + "%')";
				break;
		}

		if (!searchCategory.getSelectedItem().equals("AnyCategory"))
		{
			if (stext.length() == 0)
				query = "Select ISBN from Book where";
			query += " (Category like '" + searchCategory.getSelectedItem()
			+ "')";
		} else {
			if (stext.length() == 0)
				query = "Select ISBN from Book";			
		}
		
		System.out.println(query);

		java.sql.Connection con = BBBConnection.getConnection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
				list.add(rs.getString("ISBN"));
		} catch (SQLException error) {
			System.out.println("Book Search Querry Error");
			error.printStackTrace();
		}
		ArrayList<Book> blist = new ArrayList<Book>();
		for (String s : list)
		{
			System.out.println("Fetching " + s);
			Book b = new Book();
			b.fetchBook(s);
			blist.add(b);
		}
		return blist;
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
