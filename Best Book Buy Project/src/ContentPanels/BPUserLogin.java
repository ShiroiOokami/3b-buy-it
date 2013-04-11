package ContentPanels;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Main.BBBConnection;
import Main.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/*
 * This page is for logging on as an existing user.
 * If you provide incorrect credentials it doesn't let you log on.
 * Customers will go to the Search page.
 * Admin will go the the Admin Tasks page.
 */
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
			String querry = "SELECT PIN, UserType FROM user WHERE username LIKE '" + username.getText() + "'";
			int sPin = -1;
			String sUserType = null;
			
			///*
			try
			{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(querry);
				while(rs.next())
				{
					sPin = rs.getInt("PIN");
					sUserType = rs.getString("UserType");
				}
			}
			catch (SQLException error)
			{
				System.out.println("Querry Error");
				error.printStackTrace();
			}
			
			if (Integer.toString(sPin).equals(pin.getText()))
			{
				
				parentFrame.user.fetchUser(username.getText());
				
				if(sUserType.equals("A"))
				{
					parentFrame.switchDisplayContents(
							new BPAdministratorTask(parentFrame));
				}
				else
				{
					parentFrame.switchDisplayContents(
							new BPBookSearch(parentFrame));
				}
			}
			else 
			{
				username.setForeground(Color.RED);
				pin.setForeground(Color.RED);
			}
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		}
	}
}
