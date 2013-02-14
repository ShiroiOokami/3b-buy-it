package Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
	
	private HashMap<Book, Integer> cart = new HashMap();
	double subtotal;
	
	public ShoppingCart()
	{
		cart.put(new Book(), 0);
		subtotal = 0.00;
	}
	
	public Book addBook(Book b)
	{
		if (cart.containsKey(b))
		{
			cart.put(b, cart.get(b) + 1);
		}
		else 
		{
			cart.put(b, 1);
		}
		return b;
	}
	
	public Book removeBook(Book b)
	{
		cart.remove(b);
		return b;
	}
	
	public double getBookSubtotal(Book b)
	{
		return cart.get(b) * b.getPrice();
	}
	
	public double getSubtotal()
	{
		subtotal = 0;
		for (Map.Entry<Book, Integer> item : cart.entrySet()) {
		    Book b = item.getKey();
		    int qnty = item.getValue();
		    subtotal += getBookSubtotal(b);
		}
		return subtotal;
	}
	
	

}
