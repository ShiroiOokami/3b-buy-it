package ContentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BBBPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font;

	public BBBPanel() {
		font = new Font("Verdana", Font.BOLD, 12);
		this.setPreferredSize(new Dimension(400, 400));
		this.setBackground(Color.WHITE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	protected JPanel createHorizontalWrapper(JComponent comps[]) {
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		// p.setLayout(new GridLayout(1, comps.length, 5, 5));
		p.setLayout(new FlowLayout());

		for (JComponent c : comps)
			p.add(c);

		return p;
	}

	protected JPanel createVerticalWrapper(JComponent comps[]) {
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(comps.length, 1, 5, 5));

		for (JComponent c : comps)
			p.add(c);

		return p;
	}

	protected JScrollPane createScrollWrapper(JComponent comps[]) {
		if (comps.length == 0)
			return null;
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(comps.length, 1));
		for (JComponent c : comps)
			p.add(c);

		JScrollPane sp = new JScrollPane(p);
		Dimension d = new Dimension(comps[0].getPreferredSize());
		d.setSize(d.getWidth() + 20, d.getHeight() * 2);
		sp.setPreferredSize(d);

		return sp;
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

	protected JTextArea addTextBox() {
		JTextArea t = new JTextArea(5, 25);
		t.setFont(font);
		JScrollPane sp = new JScrollPane(t);
		this.add(sp);
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

	protected void addLabel(String name) {
		add(createLabel(name));
	}

	protected JButton addButton(String name) {
		return (JButton) add(createButton(name));
	}

	protected JTextField addField(int length) {
		return (JTextField) add(createField(length));
	}

	protected JLabel createLabel(String name) {
		JLabel j = new JLabel(name);
		j.setFont(font);
		return j;
	}

	protected JButton createButton(String name) {
		JButton j = new JButton(name);
		j.setActionCommand(name);
		return j;
	}

	protected JTextField createField(int length) {
		JTextField t = new JTextField(length);
		t.setFont(font);
		return t;
	}

	protected JComboBox<String> createCombo(String list[]) {
		JComboBox<String> b = new JComboBox<String>(list);
		b.setFont(font);
		return b;
	}

}
