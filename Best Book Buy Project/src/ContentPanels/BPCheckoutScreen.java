package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;


public class BPCheckoutScreen extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPCheckoutScreen() {
		super();
		
		this.addLabel("                    Confirm Order                    ");
		this.add(new CustomerInfo());
		this.add(new AskForCardBox());
		
		
		JComponent[] o = new JComponent[] {
				new OrderSummary(),
				new OrderSummary(),
				new OrderSummary(),
				new OrderSummary()
		};
		this.add(this.createScrollWrapper(o));

		this.addLabelLabel("Shipping Notice: The book will be here in:", "5 business days");
		this.addLabelLabel("Subtotal:", "<Subtotal>");
		this.addLabelLabel("S&H:", "<Fees>");
		this.addLabelLabel("Total:", "<Total>");
		
		this.addButton("Cancel");
		this.addButton("Update Profile");
		this.addButton("BUY IT!!!!!");
		
	}
	
	private class CustomerInfo extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private CustomerInfo() {
			font = new Font("Verdana", Font.BOLD, 9);
			this.setPreferredSize(new Dimension(200,100));
			this.setBackground(Color.WHITE);
			this.setLayout(new GridLayout(5,1));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			this.addLabel("<Shipping Address>");
			this.addLabel("<Customer Name>");
			this.addLabel("<Address>");
			this.addLabel("<City>");
			this.addLabel("<State>, <Zip>");
		}
	}
	
	private class AskForCardBox extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private AskForCardBox() {
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(150,100));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			//this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			String[] cards = {"Card on File", "Visa", "MC", "Paypal" };
			this.addCombo(cards);
			this.addField(10);
			
		}
	}
		
	private class OrderSummary extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private OrderSummary() {
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,60));
			this.setBackground(Color.WHITE);
			this.setLayout(new GridLayout(3, 1));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			this.addLabel("<The Title>");
			this.addLabel("By: Author");
			this.addLabel("Price: <Price> Qty: 1 <Cost>");
		}
	}
}
