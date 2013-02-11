package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;


public class BPDisplayReviews extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BPDisplayReviews() {
		super();
		
		this.addLabelLabel("Reviews For:", "<Title>");
		this.addLabelLabel("By:", "<Author>");
		
		JComponent[] j = new JComponent[] {
				new DisplayReview(),
				new DisplayReview(),
				new DisplayReview(),
				new DisplayReview(),
				new DisplayReview(),
				new DisplayReview()
		};
		
		this.add(this.createScrollWrapper(j));
		this.addButton("Done");
	}
	
	private class DisplayReview extends BBBPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private DisplayReview() {
			font = new Font("Verdana", Font.BOLD, 12);
			this.setBackground(Color.WHITE);
			this.setLayout(new FlowLayout());
			this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

			JTextArea a = this.addTextBox();
			Dimension d = new Dimension(a.getPreferredSize());
			d.setSize(d.getWidth() + 20, d.getHeight() + 20);
			this.setPreferredSize(d);
		}
	}
}
