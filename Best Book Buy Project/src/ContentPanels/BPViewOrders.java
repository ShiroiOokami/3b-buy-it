package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

import Main.BBBConnection;
import Main.Book;
import Main.OrderSummary;
import Main.ShoppingCart;

public class BPViewOrders extends BBBPanel {

	public BPViewOrders(JFrame frame) {
		super(frame);
		ArrayList<OrderSummary> orderList = findOrders();
		
		OrderInfo[] o = new OrderInfo[orderList.size()];
		for (int i = 0; i < orderList.size(); i++)
			o[i] = new OrderInfo(frame,orderList.get(i));
		if (orderList.size() == 0)
			addLabel("No Items on Order");
		else
			add(createScrollWrapper(o));
		
		addButton("Done");
	}

	private ArrayList<OrderSummary> findOrders() {
		ArrayList<OrderSummary> list = new ArrayList<OrderSummary>();
		java.sql.Connection con = BBBConnection.getConnection();

		try {
			String query = "select OrderNumber from book_order";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				OrderSummary sum = new OrderSummary(rs.getString("OrderNumber"));
				list.add(sum);
			}
		} catch (SQLException error) {
			System.out.println("Order List Query Error");
			error.printStackTrace();
		}

		return list;
	}
	private class OrderInfo extends BBBPanel {
		
		private static final long serialVersionUID = 1L;

		OrderSummary summary;
		public OrderInfo(JFrame frame, OrderSummary sum) {
			super(frame);
			summary = sum;
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,120));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			JComponent[] comps = new JComponent[] {
					createButton("See Order")
			};
			add(createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					createLabel("Order: " + sum.orderNum),
					createLabel("User: " + sum.user.getFirstName() + " " +
							sum.user.getLastName()),
					createLabel("Items: " + sum.cart.sizeOfCart())
			};
			add(createVerticalWrapper(comps2));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand())
			{
			case "See Order":
				parentFrame.switchDisplayContents(
						new BPPlaceOrder(parentFrame, summary));
				break;
			}
		}
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Done":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		}		
	}

}
