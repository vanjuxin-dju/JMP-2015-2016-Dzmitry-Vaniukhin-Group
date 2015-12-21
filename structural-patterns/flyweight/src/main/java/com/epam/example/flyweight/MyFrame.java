package com.epam.example.flyweight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	@SuppressWarnings("rawtypes")
	private JList list;
	private JTextField id;
	private JTextField name;
	private JCheckBox isWorker;
	private JButton add;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyFrame() {
		super("Folders");
		final DefaultListModel listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setBounds(0, 40, 300, 130);
		
		id = new JTextField();
		id.setBounds(0, 0, 75, 20);
		
		name = new JTextField();
		name.setBounds(75, 0, 75, 20);
		
		isWorker = new JCheckBox(" Worker");
		isWorker.setBounds(150, 0, 75, 20);
		
		add = new JButton("Add");
		add.setBounds(225, 0, 75, 20);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!id.getText().isEmpty() && !name.getText().isEmpty()) {
					listModel.addElement(new MyObject(Integer.parseInt(id.getText()), name.getText(), isWorker.isSelected()));
				}
			}
		});
		
		add(id);
		add(name);
		add(isWorker);
		add(add);
		add(list);

		this.setSize(300, 200);
	}

	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		myFrame.setVisible(true);
	}

}
