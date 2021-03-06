package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Main.BestBookBuy;

/*
 * This is the abstract class for the individual BP panels which represent
 * pages the user will visit in the program. This class consists entirely of
 * helper functions used by the BP pages to construct the GUI of the page.
 */
public abstract class BBBPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected Font font;
	protected BestBookBuy parentFrame;

	public BBBPanel(JFrame frame) {
		font = new Font("Verdana", Font.BOLD, 12);
		this.setPreferredSize(new Dimension(400, 400));
		this.setBackground(Color.WHITE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		parentFrame = (BestBookBuy) frame;
	}

	// Locks components together horizontally
	protected JPanel createHorizontalWrapper(JComponent comps[]) {
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new FlowLayout());

		for (JComponent c : comps)
			p.add(c);

		return p;
	}

	// Locks components together vertically
	protected JPanel createVerticalWrapper(JComponent comps[]) {
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(comps.length, 1, 5, 5));

		for (JComponent c : comps)
			p.add(c);

		return p;
	}

	// Wraps the components in a vertical scroll pane using the panel
	// provided
	protected JScrollPane createScrollWrapper(JComponent comps[], JPanel p) {
		if (comps.length == 0)
			return null;
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(comps.length, 1, 0, 0));

		for (JComponent c : comps)
			p.add(c);

		JScrollPane sp = new JScrollPane(p);
		Dimension d = comps[0].getPreferredSize();
		sp.getVerticalScrollBar().setUnitIncrement((int) d.getHeight());
		d.setSize(d.getWidth() + 20, d.getHeight() * 2);
		sp.setPreferredSize(d);

		return sp;
	}
	
	// Same as above, but creates a new panel to hold the components
	protected JScrollPane createScrollWrapper(JComponent comps[])
	{
		if (comps.length == 0)
			return null;
		return createScrollWrapper(comps, new JPanel());
	}

	protected JTextField addLabelField(String name, int length) {
		JTextField t = createField(length);
		add(createHorizontalWrapper(new JComponent[] { createLabel(name), t }));
		return t;
	}

	protected JTextField addLabelField(String name) {
		JTextField t = createField(20);
		add(createHorizontalWrapper(new JComponent[] { createLabel(name), t }));
		return t;
	}

	protected JComboBox<String> addLabelCombo(String name, String list[]) {
		JComboBox<String> b = createCombo(list);
		add(createHorizontalWrapper(new JComponent[] { createLabel(name), b }));
		return b;
	}

	protected JComboBox<String> addCombo(String list[]) {
		JComboBox<String> b = createCombo(list);
		add(b);
		return b;
	}

	protected void addLabelLabel(String name1, String name2) {
		add(createHorizontalWrapper(new JComponent[] { createLabel(name1),
				createLabel(name2) }));
	}

	protected JLabel addLabel(String name) {
		JLabel j = createLabel(name);
		add(j);
		return j;
	}

	protected JButton addButton(String name) {
		return (JButton) add(createButton(name));
	}

	protected JTextField addField(int length) {
		return (JTextField) add(createField(length));
	}
	
	protected JTextArea addTextBox() {
		return (JTextArea) add(createTextBox());
	}

	protected JLabel createLabel(String name) {
		JLabel j = new JLabel(name);
		j.setFont(font);
		return j;
	}

	protected JButton createButton(String name) {
		JButton j = new JButton(name);
		j.setActionCommand(name);
		j.addActionListener(this);
		return j;
	}

	protected JTextField createField(int length) {
		JTextField t = new JTextField(length);
		t.setFont(font);
		return t;
	}
	
	protected JTextArea createTextBox() {
		JTextArea t = new JTextArea(3, 20);
		t.setFont(font);
		//JScrollPane sp = new JScrollPane(t);
		return t;
	}

	protected JComboBox<String> createCombo(String list[]) {
		JComboBox<String> b = new JComboBox<String>(list);
		b.setFont(font);
		return b;
	}

	public <T extends Enum<T>> String[] stringList(Class<T> e) {
		T[] set = e.getEnumConstants();
		ArrayList<String> list = new ArrayList<String>();
		for (T i : set)
			list.add(i.toString());
		return list.toArray(new String[set.length]);
	}

	abstract public void actionPerformed(ActionEvent e);
}
