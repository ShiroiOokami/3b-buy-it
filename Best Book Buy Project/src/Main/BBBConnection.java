package Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BBBConnection {
	
	private static Connection con;
	
	public BBBConnection()
	{
		
	}
	
	public Connection connect()
	{
		try 
		{
			System.out.println("Connecting...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connected to driver!");
			con = DriverManager.getConnection("jdbc:mysql://db1.emich.edu/ANBBB");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver Connection Error" + e.getMessage());
		}
		
		catch (SQLException e)
		{
			System.out.println("Server Connection Error" + e.getMessage());
		}
		
		return con;
	}
	
	public static Connection getConnection()
	{
		return con;
	}

}
