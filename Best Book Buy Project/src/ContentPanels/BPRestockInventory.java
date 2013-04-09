package ContentPanels;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import Main.BBBConnection;
import Main.BestBookBuy;

public class BPRestockInventory extends BBBPanel {

	public BPRestockInventory(JFrame frame) {
		super(frame);
		this.addButton("Restock It!!!");
		this.addButton("Cancel");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Restock It!!!":
			restock();
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		}		
	}
	
	private void restock()
	{
		Connection con = BBBConnection.getConnection();
		
		String inventoryQuerry = "Select ISBN, minQty from Inventory";
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(inventoryQuerry);

			while(rs.next())
			{
				//inventoryUpdateQuerry = "Update Inventory Set  "\", Category=\"" 
			}
			
		}
		catch (SQLException error)
		{
			System.out.println("User Insertion Querry Error");
			error.printStackTrace();
		}
	}

}
