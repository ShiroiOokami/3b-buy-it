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
import Main.Book;
import Main.Subject;


public class BPSearchForBooksToModify extends BBBPanel {

	/**
	 * 
	 */
	JComboBox<String> searchByBox;
	JTextField searchField;
	JComboBox<String> searchCategory;
	private static final long serialVersionUID = 1L;

	public BPSearchForBooksToModify(JFrame frame) {
		super(frame);
		String attributes[] = {"Keyword Anywhere", 
				"Title", "Author", "Publisher", "ISBN" };
		searchField = addLabelField("Search For:", 10);
		addButton("Search");
		searchByBox = addLabelCombo("Search In: ", attributes);
		searchCategory = addLabelCombo("Category: ",
				stringList(Subject.class));
		addButton("Cancel");		
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
		
		if (stext.length() == 0)
			query = "Select ISBN from Book where";
		else
			query += " and ";
		
		query += "(Category like '" + searchCategory.getSelectedItem()
				+ "')";

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
		case "Search":
			parentFrame.switchDisplayContents(
					new BPSelectBooksForModification(parentFrame,
							performSearch()));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}
}
