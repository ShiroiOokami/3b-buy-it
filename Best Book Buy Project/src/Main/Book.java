package Main;

import java.util.ArrayList;

public class Book {
	
	private int ISBN;
	private double price;
	private String publisher, title;
	private ArrayList<String> authors = new ArrayList<String>();
	
	
	public Book ()
	{
		this.title = "<title>";
		this.ISBN = 000000000;
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
	
	public double setPrice(int price)
	{
		this.price = price;
		return price;
	}
	
	public String setPulisher(String publisher)
	{
		this.publisher = publisher;
		return publisher;
	}
	
	public ArrayList<String> setAuthors()
	{
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

}
