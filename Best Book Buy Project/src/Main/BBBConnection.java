package Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class BBBConnection {
	
	private static Connection con;
	private String serverURL = "jdbc:mysql://localhost:3306/nthomas2db?connectTimeout=3000";
	private String username = "root";
	private String password = "";
	
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
			con = DriverManager.getConnection(serverURL, username, password);
			System.out.println("Connected to server!");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver Connection Error: " + e.getMessage());
		}
		
		catch (SQLException e)
		{
			System.out.println("Server Connection Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Connection getConnection()
	{
		return con;
	}

}
