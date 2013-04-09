package Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderSummary {
	public ShoppingCart cart;
	public User user;
	public String time;
	public String date;
	public String orderNum;
	
	public OrderSummary(String num) {
		cart = new ShoppingCart();
		user = new User();
		orderNum = num;
		
		fetchOrder(num);
	}
	
	public OrderSummary(User u, ShoppingCart c)
	{
		cart = c;
		user = u;
		time = curTime();
		date = curDate();
		orderNum = nextOrder();
		
		placeOrder();
	}
	
	public String curTime()
	{
		return "12:00:00";
	}
	
	public String curDate()
	{
		return "2013-01-01";
	}
	
	public String nextOrder()
	{
		return "1";
	}
	
	public void fetchOrder(String num)
	{
		java.sql.Connection con = BBBConnection.getConnection();

		try {
			String query = "select * from book_order natural join book_order_item where OrderNumber like '" + num +"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				Book b = new Book();
				b.fetchBook(rs.getString("ISBN"));
				cart.addBook(b);
				cart.setQty(b, Integer.parseInt(rs.getString("Qty")));
				user.fetchUser(rs.getString("UserName"));
				time = rs.getString("Time");
				date = rs.getString("Date");
			}
		} catch (SQLException error) {
			System.out.println("Order Query Error");
			error.printStackTrace();
		}
	}

	public void placeOrder()
	{
		java.sql.Connection con = BBBConnection.getConnection();

		try {
			String query = "insert into book_order values ('" +
					orderNum + "', '" + date + "', '" + time + "', '" +
					user.getUserName() +"')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			for (Book b : cart.getBooksInCart())
			{
				query = "insert into book_order_item values ('" +
						orderNum + "', '" + b.getISBN() + "', '" +
						cart.getQty(b) + "')";
				stmt.executeUpdate(query);
			}
		} catch (SQLException error) {
			System.out.println("Order Update Error");
			error.printStackTrace();
		}
	}
}
