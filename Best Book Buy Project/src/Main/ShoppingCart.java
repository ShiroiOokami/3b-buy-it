package Main;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to store all of the books in a users shopping cart
 * along with their associated quantities.
 * 
 * @author Andrew
 * @version 2013-02-15
 */
public class ShoppingCart {
	
	private HashMap<Book, Integer> cart;
	double cartSubtotal;
	
	public ShoppingCart()
	{
		cart = new HashMap<Book, Integer>();
		cart.put(new Book(), 0);
		cartSubtotal = 0.00;
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
	
	public double getCartSubtotal()
	{
		cartSubtotal = 0;
		for (Map.Entry<Book, Integer> item : cart.entrySet()) {
		    cartSubtotal += getBookSubtotal(item.getKey());
		}
		return cartSubtotal;
	}
	
	

}
