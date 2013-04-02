package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Main.BBBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


@SuppressWarnings("serial")
public class BPUserLogin extends BBBPanel {

	JTextField username;
	JTextField pin;
	
	public BPUserLogin (JFrame frame) {
		super(frame);
		
		username = addLabelField("Username:", 12);
		pin = addLabelField("PIN:", 5);
		
		JComponent[] comps = new JComponent[] {
			createButton("Login"),
			createButton("Cancel")
		};
		
		add(createHorizontalWrapper(comps));
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Login":
			Connection con = BBBConnection.getConnection();
			String querry = "SELECT pin FROM user WHERE username LIKE '" + username + "'";
			int sPin = -1;
			
			try
			{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(querry);
				while(rs.next())
				{
					sPin = rs.getInt("PIN");
				}
			}
			catch (SQLException error)
			{
				System.out.println("Error");
			}
			
			if (Integer.toString(sPin).equals(pin))
			{
				parentFrame.switchDisplayContents(
					//TODO: Booksearch if customer
					new BPAdministratorTask(parentFrame));
			}
			else 
			{
				parentFrame.switchDisplayContents(
						new BPLandingPage(parentFrame));
			}
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		}
	}
}
