package Main;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * A class to store all of the associated information of a book.
 * Two Books are differentiated by their ISBN. All of the set methods
 * in the class also validate the information before setting their 
 * values.
 * 
 * The Book class also contains methods to to add and update
 * the current Book object's information to the database.
 * 
 * @author Andrew
 * @version: 2013-2-15, 2013-04-11
 *
 */
public class Book {
	
	private String publisher, title, price, minQty, ISBN, year, curQty;
	private ArrayList<String> authors = new ArrayList<String>();
	private ArrayList<String> reviews = new ArrayList<String>();
	private Subject category;
	private String deleted;
	
	
	public Book ()
	{
		this.title = "<title>";
		this.ISBN = "<isbn>";
		this.price = "<price>";
		this.publisher = "<publisher>";
		this.authors.add("<Author>");
		this.year = "<year>";
		this.minQty="<minQty>";
		this.curQty = "<curQty>";
		this.category = Subject.Horror;
		this.deleted = "Y";
	}
	
	public void setTitle(JTextField title)
	{
		if (title.getText().length() == 0)
			title.setText("<Title>");
		this.title = title.getText();
		if (checkTitle())
			unsetWarning(title);
		else
			setWarning(title);
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setISBN(JTextField ISBN)
	{
		if (ISBN.getText().length() == 0)
			ISBN.setText("<ISBN>");
		this.ISBN = ISBN.getText().replaceAll("[-]", "");
		if (checkISBN())
			unsetWarning(ISBN);
		else
			setWarning(ISBN);
	}
	
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public void setMinQty(JTextField minQty)
	{
		if (minQty.getText().length() == 0)
			minQty.setText("<Min Qty>");
		this.minQty = minQty.getText();
		if (checkMinQty())
			unsetWarning(minQty);
		else
			setWarning(minQty);
	}
	
	public void setMinQty(String minQty)
	{
		this.minQty = minQty;
	}
	
	public void setCurQty(JTextField qty)
	{
		if (qty.getText().length() == 0)
			qty.setText("<Qty>");
		this.curQty = qty.getText();
		if (checkCurQty())
			unsetWarning(qty);
		else
			setWarning(qty);
	}
	
	public void setCurQty(String qty)
	{
		this.curQty = qty;
	}
	
	public void setPrice(JTextField price)
	{
		if (price.getText().length() == 0)
			price.setText("<Price>");
		this.price = price.getText();
		if (checkPrice())
			unsetWarning(price);
		else
			setWarning(price);
	}
	
	public void setPrice(String price)
	{
		this.price = price;
	}
	
	public void setCategory(Subject s) {
		category = s;
	}
	
	public void setPulisher(JTextField publisher)
	{
		if (publisher.getText().length() == 0)
			publisher.setText("<Publisher>");
		this.publisher = publisher.getText();
		if (checkPublisher())
			unsetWarning(publisher);
		else
			setWarning(publisher);
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public void setYear(JTextField year)
	{
		if (year.getText().length() == 0)
			year.setText("<Year>");
		this.year = year.getText();
		if (checkYear())
			unsetWarning(year);
		else
			setWarning(year);
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}
	
	public void setAuthors(ArrayList<String> authors)
	{
		this.authors = new ArrayList<String>(authors);
	}
	
	public void setReviews(ArrayList<String> reviews)
	{
		this.reviews = new ArrayList<String>(reviews);
	}
	
	public void setDeleted(String dVal)
	{
		deleted = dVal;
	}
	
	public String getDeleted()
	{
		return deleted;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getISBN()
	{
		return ISBN;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public String getMinQty()
	{
		return minQty;
	}
	
	public String getCurQty()
	{
		return curQty;
	}
	
	public Subject getCategory() {
		return category;
	}
	
	public String getPulisher()
	{
		return publisher;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public ArrayList<String> getAuthors()
	{
		return authors;
	}
	
	public ArrayList<String> getReviews()
	{
		return reviews;
	}
	
	public String getAuthorString() {
		String out = "";
		for (String s : authors)
			out += s + " ";
		return out.trim();
	}
	
	private boolean checkPublisher()
	{
		return BookRegExp.publisher(publisher);
	}
	
	private boolean checkTitle()
	{
		return BookRegExp.title(title);
	}
	
	private boolean checkPrice()
	{
		return BookRegExp.price(price);
	}
	
	private boolean checkMinQty()
	{
		return BookRegExp.qty(minQty);
	}
	
	private boolean checkCurQty()
	{
		return BookRegExp.qty(curQty);
	}
	
	private boolean checkISBN()
	{
		return BookRegExp.isbn(ISBN);
	}
	
	private boolean checkYear()
	{
		return BookRegExp.year(year);
	}
	
	public boolean addPhoneNum(String s) {
		return reviews.add(s);
	}
	
	public void removeLastNum(String s) {
		if (reviews.size() > 0)
			reviews.remove(reviews.size() - 1);
	}
	
	private boolean checkReviews()
	{
		boolean pass = true;
		
		for (String review : reviews)
		{
			pass &= BookRegExp.review(review);
		}
		
		return pass;
	}
	
	private boolean checkAuthors()
	{
		boolean pass = true;
		
		for (String author : authors)
		{
			pass &= BookRegExp.author(author);
		}
		
		return pass;
	}
	
	/*
	 * Checks if all of the current books values are valid.
	 */
	public boolean checkInputs()
	{
		boolean pass = true;
		
		pass &= checkISBN();
		pass &= checkTitle();
		pass &= checkPublisher();
		pass &= checkYear();
		pass &= checkPrice();
		pass &= checkMinQty();
		pass &= checkReviews();
		pass &= checkAuthors();
		
		return pass;

	}
	
	private void unsetWarning(JTextField f) {
		f.setForeground(Color.BLACK);
	}

	private void setWarning(JTextField f) {
		f.setForeground(Color.RED);
	}
	
	/*
	 * Fetches the book associated with the passed ISBN from the
	 * database and loads the object with all of its associated values.
	 * 
	 * This methods Queries following tables:
	 * 		Book
	 * 		Inventory
	 * 		Book_Author
	 * 		Book_Review
	 */
	public void fetchBook(String byisbn)
	{
		java.sql.Connection con = BBBConnection.getConnection();
		
		String bookQuerry = "Select * from Book natural join Inventory where ISBN Like '" + byisbn + "'";
		String authorQuerry = "Select * from Book_Author where ISBN Like '" + byisbn + "'";
		String reviewQuerry = "Select * from Book_Review where ISBN Like '" + byisbn + "'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(bookQuerry);
		
			if(!rs.next())
				return;
			this.ISBN = rs.getString("ISBN");
			this.title = rs.getString("Title");
			this.publisher = rs.getString("Publisher");
			this.year = rs.getString("Year");
			this.minQty = rs.getString("MinQty");
			this.curQty = rs.getString("Qty");
			this.price = rs.getString("Price");
			this.deleted = rs.getString("Deleted");
			String s = rs.getString("Category");
			for (Subject c : Subject.values())
				if (s.equals(c.toString()))
					this.category = c;
			if (this.category == null)
				category = Subject.Misc;
			
			authors = new ArrayList<String>();
			rs = stmt.executeQuery(authorQuerry);
			while (rs.next())
				this.authors.add(rs.getString("Author"));

			reviews = new ArrayList<String>();
			rs = stmt.executeQuery(reviewQuerry);
			while (rs.next())
				this.reviews.add(rs.getString("Review"));

		} catch (SQLException error) {
			System.out.println("Book Fetch Querry Error");
			error.printStackTrace();
		}

	}
	
	/*
	 * Adds all of the books associated values into the database.
	 * 
	 * This methods inserts into the following tables:
	 * 		Book
	 * 		Inventory
	 * 		Book_Author
	 * 		Book_Review
	 */
	public boolean addBook ()
	{
		Connection con = BBBConnection.getConnection();
		
		String bookQuerry = "Insert into Book values (" + ISBN + ", \"" + title + "\", \"" + publisher + "\",\"" + category.toString() + "\", " + year + ")";
		String inventoryQuerry = "Insert into Inventory values (" + ISBN + ", 'N', " + minQty + ", 0, " + price + ")";
		
		try {
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(bookQuerry);
			stmt.executeUpdate(inventoryQuerry);

			for (String auth : authors)
			{
				String bookAuthorQuerry = "Insert into Book_Author values (" + ISBN + ", \"" + auth + "\")";
				stmt.executeUpdate(bookAuthorQuerry);
			}
			
			for (String rev : reviews)
			{
				String bookReviewQuerry = "Insert into Book_Review values (" + ISBN + ", \"" + rev + "\")";
				stmt.executeUpdate(bookReviewQuerry);
			}
			
			return true;
			
		}
		catch (SQLException error)
		{
			System.out.println("User Insertion Querry Error");
			error.printStackTrace();
			return false;
		}
	}
	
	/*
	 * This method updates all of the values of the Book corresponding to 
	 * the Book Object's ISBN.
	 * 
	 *  This method updates the following tables:
	 * 		Book
	 * 		Inventory
	 * 		Book_Author
	 * 		Book_Review
	 */
	public boolean updateBook()
	{
		Connection con = BBBConnection.getConnection();

		String bookUpdateQuerry = "Update Book Set Title=\"" + title 
				+ "\", Publisher=\"" + publisher + "\", Category=\"" 
				+ category.toString() + "\", Year=" + year + " Where ISBN=" + ISBN;
		String inventoryUpdateQuerry = "Update Inventory Set Deleted='" + deleted 
				+ "', MinQty=" + minQty + ", Price=" + price + " Where ISBN=" + ISBN;

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(bookUpdateQuerry);
			stmt.executeUpdate(inventoryUpdateQuerry);
			
			String deleteAuthors = "Delete from Book_Author Where ISBN=" + ISBN;
			stmt.executeUpdate(deleteAuthors);
			for (String auth : authors)
			{
				String bookAuthorQuerry = "Insert into Book_Author values (" + ISBN + ", \"" + auth + "\")";
				stmt.executeUpdate(bookAuthorQuerry);
			}
			
			String deleteReviews = "Delete from Book_Review Where ISBN=" + ISBN;
			stmt.executeUpdate(deleteReviews);
			for (String rev : reviews)
			{
				String bookReviewQuerry = "Insert into Book_Review values (" + ISBN + ", \"" + rev + "\")";
				stmt.executeUpdate(bookReviewQuerry);
			}
			
			return true;
		}
		
		catch (SQLException error)
		{
			System.out.println("Book Update Error");
			error.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Book)
		{
			return ISBN.matches(((Book) obj).ISBN);
		}
		else 
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return ISBN.hashCode();
	}

}
