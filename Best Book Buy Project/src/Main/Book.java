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
		this.title = title.getText();
		if(this.title.length() == 0)
			this.title = "<User Name>";
		if (checkTitle())
			unsetWarning(title);
		else
			setWarning(title);
	}
	
	public void setISBN(JTextField ISBN)
	{
		this.ISBN = ISBN.getText();
		if(this.ISBN.length() == 0)
			this.ISBN = "<ISBN>";
		this.ISBN = ISBN.getText().replaceAll("[-]", "");
		if (checkISBN())
			unsetWarning(ISBN);
		else
			setWarning(ISBN);
	}
	
	public void setMinQty(JTextField minQty)
	{
		this.minQty = minQty.getText();
		if(this.ISBN.length() == 0)
			this.minQty = "<MinQty>";
		this.minQty = minQty.getText();
		if (checkMinQty())
			unsetWarning(minQty);
		else
			setWarning(minQty);
	}
	
	public void setPrice(JTextField price)
	{
		this.price = price.getText();
		if (checkPrice())
			unsetWarning(price);
		else
			setWarning(price);
	}
	
	public void setPulisher(JTextField publisher)
	{
		this.publisher = publisher.getText();
		if (checkPublisher())
			unsetWarning(publisher);
		else
			setWarning(publisher);
	}
	
	public void setYear(JTextField year)
	{
		this.year = year.getText();
		if (checkYear())
			unsetWarning(year);
		else
			setWarning(year);
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
	
	// TODO: Implement
	private boolean checkReview()
	{
		return true;
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
		pass &= checkReview();
		
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
