package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

public class BPShoppingCart extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPShoppingCart(JFrame frame) {
		super(frame);
		
		addButton("Checkout");
		addButton("New Search");
		
		JComponent[] j = new JComponent[] {
				new ShopCartItem(frame),
				new ShopCartItem(frame),
				new ShopCartItem(frame)
		};
		
		this.add(this.createScrollWrapper(j));

		this.addLabel(
		"                                                       Subtotal: <Price>");
		addButton("Recalculate Total");
		
		addButton("Exit");
	}
	
	private class ShopCartItem extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private ShopCartItem(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,75));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			this.addButton("Remove");
			JComponent[] comps = new JComponent[] {
					this.createLabel("<This is a Really Long Title>"),
					this.createLabel("By: <Author>"),
					this.createLabel("Price: <Price>")
			};
			this.add(this.createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					this.createField(3),
					this.createLabel("<Cost>")
			};
			
			this.add(this.createVerticalWrapper(comps2));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Exit":
			parentFrame.switchDisplayContents(
					new BPLandingPage(parentFrame));
			break;
		case "New Search":
			parentFrame.switchDisplayContents(
					new BPBookSearch(parentFrame));
			break;
		case "Recalculate Total":
			// Do Stuff
			break;
		case "Checkout":
			parentFrame.switchDisplayContents(
					new BPCheckoutScreen(parentFrame));
			break;
		}
	}
}
