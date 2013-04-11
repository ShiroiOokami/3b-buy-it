package ContentPanels;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.CardType;
import Main.USState;
import Main.User;
import Main.UserRegExps;

/*
 * This page updates the Administrator Profile, it does not allow you to
 * modify the username.
 */
public class BPUpdateAdministratorProfile extends BBBPanel {

	private static final long serialVersionUID = 1L;

	private JTextField PIN;
	private JTextField retypePIN;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField city;
	private JTextField zip;
	private JComboBox state;
	private JTextField[] phones;
	private JScrollPane pscroll;
	private JPanel ppanel;
	
	User user = parentFrame.user;
	
	public BPUpdateAdministratorProfile(JFrame frame) {
		super(frame);
		
		addLabel("Username: " + parentFrame.user.getUserName());
		addLabel("Date of Hire: " + parentFrame.user.getHireDate());
		PIN = addLabelField("New Pin", 5);
		retypePIN = addLabelField("Re-type PIN:", 5);
		firstName = addLabelField("First Name:", 25);
		lastName = addLabelField("Last Name:", 25);
		address = addLabelField("Address:", 25);
		city = addLabelField("City:", 25);
		state = addLabelCombo("State:", stringList(USState.class));
		zip = addLabelField("ZIP:", 8);
		
		ArrayList<String> pnums = parentFrame.user.getPhoneNums();
		phones = new JTextField[Math.max(pnums.size(),1)];
		for (int i = 0; i < pnums.size(); i++)
			phones[i] = new JTextField(pnums.get(i),10);
		if (pnums.size() == 0)
			phones[0] = new JTextField(10);
		
		ppanel = new JPanel();
		pscroll = createScrollWrapper(phones, ppanel);
		add(pscroll);
		JComponent[] k = new JComponent[] {
			createButton("More Phone Nums"),
			createButton("Fewer Phone Nums"),
		};
		this.add(this.createVerticalWrapper(k));
		
		JComponent[] l = new JComponent[] {
			createButton("Update"),
			createButton("Cancel")
		};
		
		eatUser();
		
		add(createHorizontalWrapper(l));
	}
	
	private void feedUser()
	{
		User user = parentFrame.user;
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPIN(PIN);
		user.setAddress(address);
		user.setCity(city);
		user.setZIP(zip);
		user.setState(USState.values()[state.getSelectedIndex()]);
		
		ArrayList<String> pnum = new ArrayList<String>();
		for (JTextField p : phones)
			if (UserRegExps.phone(p.getText()))
				pnum.add(p.getText());
		user.setPhoneNum(pnum);
	}
	
	private void eatUser()
	{	
		firstName.setText(user.getFirstName());
		lastName.setText(user.getLastName());
		PIN.setText(user.getPIN());
		address.setText(user.getAddress());
		city.setText(user.getCity());
		zip.setText(user.getZIP());
		state.setSelectedIndex(user.getState().ordinal());

	}
	
	public void addPhone() {
		JTextField[] np = Arrays.copyOf(phones, phones.length + 1);
		np[np.length - 1] = new JTextField(10);

		GridLayout lm = (GridLayout) ppanel.getLayout();
		lm.setRows(np.length);
		ppanel.add(np[np.length -1]);		
		phones = np;
		ppanel.updateUI();
	}

	public void removePhone() {
		if (phones.length <= 1)
			return;
		JTextField[] np = Arrays.copyOf(phones, phones.length - 1);

		GridLayout lm = (GridLayout) ppanel.getLayout();
		lm.setRows(np.length);
		ppanel.remove(phones[phones.length - 1]);
		phones = np;
		ppanel.updateUI();
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "More Phone Nums":
			addPhone();
			break;
		case "Fewer Phone Nums":
			removePhone();
			break;
		case "Update":
			feedUser();
			if (parentFrame.user.checkAdmin())
			{
				user.updateAdmin();
				parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			}
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		}		
	}
}
