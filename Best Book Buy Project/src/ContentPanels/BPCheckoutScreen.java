package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

import Main.CardType;


public class BPCheckoutScreen extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPCheckoutScreen(JFrame frame) {
		super(frame);
		
		this.addLabel("                    Confirm Order                    ");
		this.add(new CustomerInfo(frame));
		this.add(new AskForCardBox(frame));
		
		
		JComponent[] o = new JComponent[] {
				new OrderSummary(frame),
				new OrderSummary(frame),
				new OrderSummary(frame)
		};
		this.add(this.createScrollWrapper(o));

		this.addLabelLabel("Shipping Notice: The book will be here in:", "5 business days");
		this.addLabelLabel("Subtotal:", "<Subtotal>");
		this.addLabelLabel("S&H:", "<Fees>");
		this.addLabelLabel("Total:", "<Total>");
		
		this.addButton("New Search");
		this.addButton("Update Profile");
		this.addButton("BUY IT!!!!!!");
		
	}
	
	private class CustomerInfo extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private CustomerInfo(JFrame frame) {
			super(frame);
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class AskForCardBox extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private AskForCardBox(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(150,100));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			//this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			this.addCombo(stringList(CardType.class));
			this.addField(10);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
		
	private class OrderSummary extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private OrderSummary(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,60));
			this.setBackground(Color.WHITE);
			this.setLayout(new GridLayout(3, 1));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			this.addLabel("<The Title>");
			this.addLabel("By: Author");
			this.addLabel("Price: <Price> Qty: 1 <Cost>");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "New Search":
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		case "Update Profile":
			parentFrame.switchDisplayContents(
					new BPUpdateCustomer(parentFrame));
			break;
		case "BUY IT!!!!!!":
			parentFrame.switchDisplayContents(
					new BPProofOfPurchase(parentFrame));
			break;			
		}
	}
}
