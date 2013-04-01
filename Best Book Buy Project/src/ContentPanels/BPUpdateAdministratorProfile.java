package ContentPanels;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.CardType;
import Main.USState;
import Main.User;


public class BPUpdateAdministratorProfile extends BBBPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField PIN;
	private JTextField retypePIN;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField address;
	private JTextField city;
	private JTextField zip;
	private JComboBox state;
	private JScrollPane phones;
	
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
		JTextField[] phoneDisplay = new JTextField[Math.max(pnums.size(),1)];
		for (int i = 0; i < pnums.size(); i++)
			phoneDisplay[i] = new JTextField(pnums.get(i),10);
		if (pnums.size() == 0)
			phoneDisplay[0] = new JTextField(10);
		
		phones = createScrollWrapper(phoneDisplay);
		add(phones);
		JComponent[] k = new JComponent[] {
			createButton("More Phone Nums"),
			createButton("Fewer Phone Nums"),
		};
		this.add(this.createVerticalWrapper(k));
		eatUser();
		
		JComponent[] l = new JComponent[] {
			createButton("Update"),
			createButton("Cancel")
		};

		this.add(this.createHorizontalWrapper(l));
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
	}
	
	private void eatUser()
	{
		User user = parentFrame.user;
		
		firstName.setText(user.getFirstName());
		lastName.setText(user.getLastName());
		PIN.setText(user.getPIN());
		address.setText(user.getAddress());
		city.setText(user.getCity());
		zip.setText(user.getZIP());
		state.setSelectedIndex(user.getState().ordinal());
	}


	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "More Phone Nums":
			// More Ways To Disrupt My Evening
			break;
		case "Fewer Phone Nums":
			// You Get it
			break;
		case "Update":
			feedUser();
			if (parentFrame.user.checkCustomer())
				parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		case "Cancel":
			parentFrame.switchDisplayContents(
					new BPAdministratorTask(parentFrame));
			break;
		}		
	}
}
