package Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		decrementInventory();
	}
	
	public String curTime()
	{
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		return sd.format(new Date());
	}
	
	public String curDate()
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(new Date());
	}
	
	public String nextOrder()
	{
		ArrayList<String> ordernums = orderNums();
		
		for (int i = 1; i < 1000; i++)
			if (!ordernums.contains(Integer.toString(i)))
				return Integer.toString(i);
		
		return "000";
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
	
	private ArrayList<String> orderNums() {
		ArrayList<String> list = new ArrayList<String>();
		java.sql.Connection con = BBBConnection.getConnection();

		try {
			String query = "select OrderNumber from book_order";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				list.add(rs.getString("OrderNumber"));
			}
		} catch (SQLException error) {
			System.out.println("Order List Query Error");
			error.printStackTrace();
		}

		return list;
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

	public void decrementInventory()
	{
		java.sql.Connection con = BBBConnection.getConnection();

		try {
			Statement stmt = con.createStatement();
			
			for (Book b : cart.getBooksInCart())
			{
				String query = "update inventory set Qty='" +
						(Integer.parseInt(b.getCurQty()) - cart.getQty(b)) +
						"' where ISBN like '" + b.getISBN() + "'";
				stmt.executeUpdate(query);
				b.setCurQty("" + (Integer.parseInt(b.getCurQty()) - cart.getQty(b)));
			}
		} catch (SQLException error) {
			System.out.println("Order Update Error");
			error.printStackTrace();
		}
	}

	public void deleteOrder()
	{
		java.sql.Connection con = BBBConnection.getConnection();

		try {
			String query = "delete from book_order_item where OrderNumber like '" +
					orderNum + "'";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			query = "delete from book_order where OrderNumber like '" +
					orderNum + "'";
			stmt.executeUpdate(query);
			
		} catch (SQLException error) {
			System.out.println("Order Delete Error");
			error.printStackTrace();
		}		
	}
}
