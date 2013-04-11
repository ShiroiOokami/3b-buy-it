package ContentPanels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Main.Book;
import Main.BookRegExp;
import Main.Subject;
import Main.USState;
import Main.UserRegExps;

/*
 * This page is for inserting a new book. It generates red text error messages
 * wherever a field is entered in incorrectly.
 */
public class BPInsertNewBook extends BBBPanel {

	private JTextField isbn;
	private JTextField title;
	private JTextField publisher;
	private JTextField year;
	private JTextField price;
	private JTextField minQty;
	private Book book = new Book();
	private JTextField[] author;
	private JScrollPane ascroll;
	private JPanel apanel;
	private JTextArea[] review;
	private JScrollPane rscroll;
	private JPanel rpanel;
	private JComboBox subject;

	private static final long serialVersionUID = 1L;

	public BPInsertNewBook(JFrame frame) {
		super(frame);
		
		isbn = addLabelField("ISBN:", 15);
		
		title = addLabelField("Title:", 20);
		ArrayList<String> atrs = book.getAuthors();
		author = new JTextField[Math.max(atrs.size(),1)];
		for (int i = 0; i < atrs.size(); i++)
			author[i] = new JTextField(atrs.get(i),10);
		if (atrs.size() == 0)
			author[0] = new JTextField(10);
		
		apanel = new JPanel();
		ascroll = createScrollWrapper(author, apanel);
		add(ascroll);
		JComponent[] k = new JComponent[] {
			createButton("More Authors"),
			createButton("Fewer Authors")
		};
		add(createVerticalWrapper(k));

		publisher = addLabelField("Publisher:", 20);
		year = addLabelField("Year:", 6);
		subject = addLabelCombo("Category",
				stringList(Subject.class));
		price = addLabelField("Price:", 8);
		minQty = addLabelField("Min. Qty. Req. In Stock:", 3);
		ArrayList<String> rvws = book.getReviews();
		review = new JTextArea[Math.max(rvws.size(),1)];
		for (int i = 0; i < rvws.size(); i++)
		{
			review[i] = new JTextArea(rvws.get(i),3, 20);
			review[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
		}
		if (rvws.size() == 0)
			review[0] = new JTextArea(3, 20);
		
		rpanel = new JPanel();
		rscroll = createScrollWrapper(review, rpanel);
		add(rscroll);
		
		k = new JComponent[] {
				createButton("More Reviews"),
				createButton("Fewer Reviews")
		};
		add(createVerticalWrapper(k));
		addButton("Insert");
		addButton("Cancel");
	}
	
	private void feedBook()
	{
		
		book.setISBN(isbn);
		book.setMinQty(minQty);
		book.setPrice(price);
		book.setPulisher(publisher);
		book.setTitle(title);
		book.setYear(year);
		book.setCategory(Subject.values()[subject.getSelectedIndex()]);
		if (!book.checkSubject())
			subject.setForeground(Color.RED);
		else
			subject.setForeground(Color.BLACK);
		ArrayList<String> atrs = new ArrayList<String>();
		for (JTextField a : author)
			if (BookRegExp.author(a.getText()))
				atrs.add(a.getText());
		book.setAuthors(atrs);
		ArrayList<String> rvws = new ArrayList<String>();
		for (JTextArea a : review)
			if (BookRegExp.review(a.getText()))
				rvws.add(a.getText());
		book.setReviews(rvws);
	}
	
	public void addAuthor() {
		JTextField[] np = Arrays.copyOf(author, author.length + 1);
		np[np.length - 1] = new JTextField(10);

		GridLayout lm = (GridLayout) apanel.getLayout();
		lm.setRows(np.length);
		apanel.add(np[np.length -1]);		
		author = np;
		apanel.updateUI();
	}

	public void removeAuthor() {
		if (author.length <= 1)
			return;
		JTextField[] np = Arrays.copyOf(author, author.length - 1);

		GridLayout lm = (GridLayout) apanel.getLayout();
		lm.setRows(np.length);
		apanel.remove(author[author.length - 1]);
		author = np;
		apanel.updateUI();
	}

	public void addReview() {
		JTextArea[] np = Arrays.copyOf(review, review.length + 1);
		np[np.length - 1] = new JTextArea(3,20);
		np[np.length - 1].setBorder(BorderFactory.createLineBorder(Color.lightGray));

		GridLayout lm = (GridLayout) rpanel.getLayout();
		lm.setRows(np.length);
		rpanel.add(np[np.length -1]);		
		review = np;
		rpanel.updateUI();
	}

	public void removeReview() {
		if (review.length <= 1)
			return;
		JTextArea[] np = Arrays.copyOf(review, review.length - 1);

		GridLayout lm = (GridLayout) rpanel.getLayout();
		lm.setRows(np.length);
		rpanel.remove(review[review.length - 1]);
		review= np;
		rpanel.updateUI();
	}


	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "More Reviews":
			addReview();
			break;
		case "Fewer Reviews":
			removeReview();
			break;
		case "More Authors":
			addAuthor();
			break;
		case "Fewer Authors":
			removeAuthor();
			break;
		case "Insert":
			feedBook();
			if (book.checkInputs() && book.getAuthors().size() !=  0)
			{
				if (book.addBook()) {
					parentFrame.switchDisplayContents(
							new BPManageBookstoreCatalog(parentFrame));
				} else {
					isbn.setText("ISBN Already in Use");
					isbn.setForeground(Color.RED);
				}
			}
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPManageBookstoreCatalog(parentFrame));
			break;
		}		
	}

}
