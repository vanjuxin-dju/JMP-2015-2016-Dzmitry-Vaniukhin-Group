package com.epam.example.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	private JList myListBox1;
	@SuppressWarnings("rawtypes")
	private JList myListBox2;
	private JTextField fieldValue;
	private JButton buttonAdd;
	private JButton buttonMove;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyFrame(){
		super("Lists");
		final ListModelAdapter listModel1 = new ListModelAdapter();
		final ListModelAdapter listModel2 = new ListModelAdapter();
		myListBox1 = new JList(listModel1.getListModel());
		myListBox1.setLayoutOrientation(JList.VERTICAL);
		myListBox1.setBounds(0, 40, 150, 160);
		myListBox2 = new JList(listModel2.getListModel());
		myListBox2.setLayoutOrientation(JList.VERTICAL);
		myListBox2.setBounds(150, 40, 150, 160);
		fieldValue = new JTextField();
		fieldValue.setBounds(0, 0, 300, 20);
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(0, 20, 150, 20);
		buttonMove = new JButton("Move");
		buttonMove.setBounds(150, 20, 150, 20);
		
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!fieldValue.getText().isEmpty()) {
					listModel1.addElement(fieldValue.getText());
				}
			}
		});
		
		buttonMove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel2.moveElements(listModel1);
			}
		});
		
		add(myListBox1);
		add(fieldValue);
		add(buttonAdd);
		add(buttonMove);
		add(myListBox2);
		
		this.setSize(300, 200);
	}



	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		//frame.pack();
	}
}
