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


public class BPBookSearchResult extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPBookSearchResult(JFrame frame) {
		super(frame);
		
		this.addLabel("Your Shopping Cart Has 6 items");
		this.addButton("Shopping Cart");
		JComponent[] j = new JComponent[] {
				new SearchResults(frame),
				new SearchResults(frame),
				new SearchResults(frame)
				};
		this.add(this.createScrollWrapper(j));
		this.addButton("Checkout");
		this.addButton("New Search");
		this.addButton("Exit");
	}
	
	private class SearchResults extends BBBPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SearchResults(JFrame frame) {
			super(frame);
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,120));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			JComponent[] comps = new JComponent[] {
					this.createButton("Add to Cart"),
					this.createButton("Reviews")
			};
			this.add(this.createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					this.createLabel("Title: <Title>"),
					this.createLabel("Author: <Author Author>"),
					this.createLabel("Publisher: <Publisher Publisher>"),
					this.createLabel("ISBN: <ISBN>"),
					this.createLabel("Price: Free Today")
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
		case "Checkout":
			parentFrame.switchDisplayContents(
					new BPCheckoutScreen(parentFrame));
			break;
		case "Shopping Cart":
			parentFrame.switchDisplayContents(
				new BPShoppingCart(parentFrame));
			break;			
		}
	}
}
