/**
 * 
 */
package com.epam.example.bridge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	@SuppressWarnings("rawtypes")
	private JList list;
	private JTable table;
	private JTextField field;
	private JButton add;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyFrame() {
		super("List and Table");
		
		final DefaultListModel listModel = new DefaultListModel();
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Name");
		
		list = new JList(listModel);
		list.setBounds(0, 0, 150, 160);
		table = new JTable(tableModel);
		table.setBounds(150, 0, 150, 160);
		field = new JTextField();
		field.setBounds(0, 160, 240, 20);
		add = new JButton("Add");
		add.setBounds(240, 160, 60, 20);
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!field.getText().isEmpty()) {
					listModel.addElement(field.getText());
					tableModel.addRow(new String[] { field.getText() });
				}
			}
		}); 
		
		add(list);
		add(table);
		add(field);
		add(add);
		
		
		this.setSize(300, 240);
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}
}
