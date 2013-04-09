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
		
		String inventoryQuerry = "Select ISBN, Qty, minQty, Deleted from Inventory";
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(inventoryQuerry);

			while(rs.next())
			{
				int cQty = rs.getInt("Qty");
				int mQty = rs.getInt("MinQty");
				if(rs.getString("Deleted").equals("N") && (cQty < mQty))
				{
					String inventoryUpdateQuerry = "Update Inventory Set Qty=" + rs.getString("MinQty") 
							+ " Where ISBN=" + rs.getString("ISBN");
					Statement uStmt = con.createStatement();
					uStmt.executeUpdate(inventoryUpdateQuerry);
				}
			}
			
			rs.close();
			
		}
		catch (SQLException error)
		{
			System.out.println("User Insertion Querry Error");
			error.printStackTrace();
		}
	}

}
