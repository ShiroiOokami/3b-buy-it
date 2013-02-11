package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;


public class BPBookSearchResult extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPBookSearchResult() {
		super();
		
		this.addLabel("Your Shopping Cart Has 6 items");
		this.addButton("Shopping Cart");
		JComponent[] j = new JComponent[] {
				new SearchResults(),
				new SearchResults(),
				new SearchResults(),
				new SearchResults(),
				new SearchResults(),
				new SearchResults()
				};
		this.add(this.createScrollWrapper(j));
		this.addButton("Checkout");
		this.addButton("New Search");
		this.addButton("Cancel");
	}
	
	private class SearchResults extends BBBPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SearchResults() {
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
	}
}
