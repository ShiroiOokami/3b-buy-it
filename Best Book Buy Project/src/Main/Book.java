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
	
	private String publisher, title, price, minQty, ISBN, year;
	private ArrayList<String> authors = new ArrayList<String>();
	private ArrayList<String> reviews = new ArrayList<String>();
	
	
	public Book ()
	{
		this.title = "<title>";
		this.ISBN = "0000000000000";
		this.price = "0.00";
		this.publisher = "<publisher>";
		this.authors.add("<Author>");
	}
	
	public boolean setTitle(String title)
	{
		this.title = title;
		return checkTitle();
	}
	
	public boolean setISBN(String ISBN)
	{
		this.ISBN = ISBN;
		return checkISBN();
	}
	
	public boolean setMinQty(String minQty)
	{
		this.minQty = minQty;
		return checkMinQty();
	}
	
	public boolean setPrice(String price)
	{
		this.price = price;
		return checkPrice();
	}
	
	public boolean setPulisher(String publisher)
	{
		this.publisher = publisher;
		return checkPublisher();
	}
	
	public boolean setYear(String year)
	{
		this.year = year;
		return checkYear();
	}
	
	public ArrayList<String> setAuthors(ArrayList<String> authors)
	{
		this.authors = new ArrayList<String>(authors);
		return authors;
	}
	
	public ArrayList<String> setReviews(ArrayList<String> reviews)
	{
		this.reviews = new ArrayList<String>(reviews);
		return authors;
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
	
	// TODO: Implementet
	private boolean checkReview()
	{
		return true;
	}
	
	public boolean checkInputs()
	{
		boolean pass = true;
		
		if (!(pass &= checkISBN()))
			System.out.println("Failed ISBN");
		if (!(pass &= checkTitle()))
			System.out.println("Failed title");
		if (!(pass &= checkPublisher()))
			System.out.println("Failed publisher");
		if (!(pass &= checkYear()))
			System.out.println("Failed year");
		if (!(pass &= checkPrice()))
			System.out.println("Failed price");
		if (!(pass &= checkMinQty()))
			System.out.println("Failed MinQty");
		if (!(pass &= checkReview()))
			System.out.println("Failed review");
		
		return pass;

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
