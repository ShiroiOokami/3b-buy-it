package ContentPanels;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Main.Book;
import Main.BookRegExp;
import Main.Subject;
import Main.UserRegExps;


public class BPInsertNewBook extends BBBPanel {

	private JTextField textIsbn;
	private String sIsbn;
	private JTextField title;
	private JTextField publisher;
	private JTextField year;
	private JTextField price;
	private JTextField minQty;
	private JTextArea review;
	private Book book = new Book();
	
	private static final long serialVersionUID = 1L;

	public BPInsertNewBook(JFrame frame) {
		super(frame);
		
		textIsbn = this.addLabelField("ISBN:", 15);
		
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
	
	private void feedBook()
	{
		
		//System.out.println("Orig: " + textIsbn.getText());
		sIsbn = textIsbn.getText().replaceAll("[-]", "");
		//System.out.println("Converted: " + sIsbn);
		
		book.setISBN(sIsbn);
		book.setMinQty(minQty.getText());
		book.setPrice(price.getText());
		book.setPulisher(publisher.getText());
		book.setTitle(title.getText());
		book.setYear(year.getText());
		book.setReviews(new ArrayList<String>());
		
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
			
			if (book.checkInputs())
			{
				parentFrame.switchDisplayContents(
						new BPManageBookstoreCatalog(parentFrame));
			}
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}

}
