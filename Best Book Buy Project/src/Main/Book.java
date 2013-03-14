package Main;

import java.util.ArrayList;

/**
 * A class to store all of the associated information of a book.
 * Two Books are differentiated by their ISBN.
 * 
 * @author Andrew
 * @version: 2013-2-15
 *
 */
public class Book {
	
	private int ISBN;
	private double price;
	private String publisher, title;
	private ArrayList<String> authors = new ArrayList<String>();
	
	
	public Book ()
	{
		this.title = "<title>";
		this.ISBN = 0;
		this.price = 0.00;
		this.publisher = "<publisher>";
		this.authors.add("<Author>");
	}
	
	public String setTitle(String title)
	{
		this.title = title;
		return title;
	}
	
	public int setISBN(int ISBN)
	{
		this.ISBN = ISBN;
		return ISBN;
	}
	
	public double setPrice(double price)
	{
		this.price = price;
		return price;
	}
	
	public String setPulisher(String publisher)
	{
		this.publisher = publisher;
		return publisher;
	}
	
	public ArrayList<String> setAuthors(ArrayList<String> authors)
	{
		this.authors = new ArrayList<String>(authors);
		return authors;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getISBN()
	{
		return ISBN;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String getPulisher()
	{
		return publisher;
	}
	
	public ArrayList<String> getAuthors()
	{
		return authors;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Book)
		{
			return ISBN == ((Book) obj).ISBN;
		}
		else 
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return ((Integer) ISBN).hashCode();
	}

}
