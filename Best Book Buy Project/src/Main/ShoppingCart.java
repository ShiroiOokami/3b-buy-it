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
	
	public void setQty(Book b, int q)
	{
		cart.put(b, q);
	}
	
	public ArrayList<Book> getBooksInCart() {
		ArrayList<Book> list = new ArrayList<Book>();
		for (Book b : cart.keySet())
			list.add(b);
		return list;
	}
	
	public int sizeOfCart() {
		return cart.size();
	}
	public int getQty(Book b)
	{
		return cart.containsKey(b) ? cart.get(b) : 0;
	}
	
	public Book removeBook(Book b)
	{
		cart.remove(b);
		return b;
	}
	
	public double getBookSubtotal(Book b)
	{
		if (cart.containsKey(b))
			return cart.get(b) * Double.parseDouble(b.getPrice());
		else
			return 0;
	}
	
	public double getCartSubtotal()
	{
		cartSubtotal = 0;
		for (Map.Entry<Book, Integer> item : cart.entrySet()) {
		    cartSubtotal += getBookSubtotal(item.getKey());
		}
		return cartSubtotal;
	}
	
	public String getBookSubtotalString(Book b)
	{
		return String.format("%.2f", getBookSubtotal(b));
	}
	
	public String getCartSubtotalString()
	{
		return String.format("%.2f", getCartSubtotal());
	}
}
