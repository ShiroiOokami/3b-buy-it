package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;

public class BPShoppingCart extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPShoppingCart() {
		super();
		
		this.addButton("Checkout");
		this.addButton("New Search");
		
		JComponent[] j = new JComponent[] {
				new ShopCartItem(),
				new ShopCartItem(),
				new ShopCartItem(),
				new ShopCartItem(),
				new ShopCartItem(),
				new ShopCartItem(),
				new ShopCartItem()
		};
		
		this.add(this.createScrollWrapper(j));

		this.addLabel(
		"                                                       Subtotal: <Price>");
		this.addButton("Recalculate Total");
		
		this.addButton("Cancel");
	}
	
	private class ShopCartItem extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private ShopCartItem() {
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
	}
}
