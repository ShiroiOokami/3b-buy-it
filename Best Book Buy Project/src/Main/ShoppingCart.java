package Main;

import java.util.ArrayList;
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
		cartSubtotal = 0.00;
	}
	
	public Book addBook(Book b)
	{
		if (cart.containsKey(b))
			cart.put(b, cart.get(b) + 1);
		else 
			cart.put(b, 1);
		return b;
	}
	
	public ArrayList<Book> getBooksInCart() {
		ArrayList<Book> list = new ArrayList<Book>();
		for (Book b : cart.keySet())
			list.add(b);
		return list;
	}
	
	public int itemsInCart() {
		int count = 0;
		for (Book b : cart.keySet())
			count += cart.get(b);
		
		return count;
	}
	public int getQty(Book b)
	{
		return cart.get(b) == null ? 0 : cart.get(b);
	}
	
	public Book removeBook(Book b)
	{
		cart.remove(b);
		return b;
	}
	
	public double getBookSubtotal(Book b)
	{
		return cart.get(b) * Integer.parseInt(b.getPrice());
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
