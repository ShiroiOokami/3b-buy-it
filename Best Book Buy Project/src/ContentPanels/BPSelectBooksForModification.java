package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;


public class BPSelectBooksForModification extends BBBPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPSelectBooksForModification() {
		super();
		
		JComponent[] comps = new JComponent[] {
				new SearchResults(),
				new SearchResults(),
				new SearchResults(),
				new SearchResults(),
				new SearchResults(),
				new SearchResults()
				};
		
		add(this.createScrollWrapper(comps));
		addButton("Done");
	}
	
	private class SearchResults extends BBBPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SearchResults() {
			font = new Font("Verdana", Font.BOLD, 12);
			this.setPreferredSize(new Dimension(350,140));
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			JComponent[] comps = new JComponent[] {
					this.createButton("Delete"),
					this.createButton("Update")
			};
			this.add(this.createVerticalWrapper(comps));
			
			JComponent[] comps2 = new JComponent[] {
					this.createLabel("Title: <Title>"),
					this.createLabel("Author: <Author Author>"),
					this.createLabel("Publisher: <Publisher Publisher>"),
					this.createLabel("ISBN: <ISBN>"),
					this.createLabel("Price: Free Today"),
					this.createLabel("<Flag if Deleted>")
			};
			this.add(this.createVerticalWrapper(comps2));
		}
	}

}
