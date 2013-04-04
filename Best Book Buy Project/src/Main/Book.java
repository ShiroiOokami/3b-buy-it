package Main;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * A class to store all of the associated information of a book.
 * Two Books are differentiated by their ISBN.
 * 
 * @author Andrew
 * @version: 2013-2-15
 *
 */
public class Book {
	
	private String publisher, title, price, minQty, ISBN, year;
	private ArrayList<String> authors = new ArrayList<String>();
	private ArrayList<String> reviews = new ArrayList<String>();
	
	
	public Book ()
	{
		this.title = "<title>";
		this.ISBN = "<isbn>";
		this.price = "<price>";
		this.publisher = "<publisher>";
		this.authors.add("<Author>");
		this.year = "<year>";
		this.minQty="<minQty>";
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
		return BookRegExp.minQty(minQty);
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
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Book)
		{
			return Integer.parseInt(ISBN) == Integer.parseInt(((Book) obj).ISBN);
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
