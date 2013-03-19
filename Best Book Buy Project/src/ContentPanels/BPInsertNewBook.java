package ContentPanels;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Main.BookRegExp;
import Main.Subject;
import Main.UserRegExps;


public class BPInsertNewBook extends BBBPanel {

	private JTextField isbn;
	private JTextField title;
	private JTextField publisher;
	private JTextField year;
	private JTextField price;
	private JTextField minQty;
	private JTextArea review;
	
	private static final long serialVersionUID = 1L;

	public BPInsertNewBook(JFrame frame) {
		super(frame);
		
		isbn = this.addLabelField("ISBN:", 15);
		title = this.addLabelField("Title:", 20);
		//this.SpecialStuff
		this.addButton("More Authors");
		this.addButton("Fewer Authors");
		publisher = this.addLabelField("Publisher:", 20);
		year = this.addLabelField("Year:", 6);
		this.addLabelCombo("Category",
				stringList(Subject.class));
		price = this.addLabelField("Price:", 8);
		minQty = this.addLabelField("Min. Qty. Req. In Stock:", 3);
		this.addLabel("Reviews:");

		review = this.addTextBox();
		this.addButton("More Reviews");
		this.addButton("Fewer Reviews");
		
		this.addButton("Insert");
		this.addButton("Cancel");
	}
	
	private boolean checkInputs()
	{
		boolean pass = true;
		if (!BookRegExp.isbn(isbn.getText()))
			System.out.println("Failed ISBN");
		if (!BookRegExp.title(title.getText()))
			System.out.println("Failed title");
		if (!BookRegExp.publisher(publisher.getText()))
			System.out.println("Failed publisher");
		if (!BookRegExp.year(year.getText()))
			System.out.println("Failed year");
		if (!BookRegExp.price(price.getText()))
			System.out.println("Failed price");
		if (!BookRegExp.minQty(minQty.getText()))
			System.out.println("Failed MinQty");
		if (!BookRegExp.review(review.getText()))
			System.out.println("Failed review");

		return pass;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "More Reviews":
			// Deceive Customers More
			break;
		case "Fewer Reviews":
			// Deceive Customers Less
			break;
		case "More Authors":
			// Pay Current Authors Less
			break;
		case "Fewer Authors":
			// Pay Current Authors More
			break;
		case "Insert":
			if (checkInputs())
			{
				//parentFrame.switchDisplayContents(
				//	new BPManageBookstoreCatalog(parentFrame));
			}
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}

}
