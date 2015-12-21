package com.epam.example.decorator;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	private JButton regularButton;
	private JButton adminButton;
	
	public MyFrame() {
		super("Decorated buttons");
		
		regularButton = new JButton("View");
		regularButton.setBounds(0, 0, 150, 20);
		adminButton = new AdminButton("Remove");
		adminButton.setBounds(150, 0, 150, 20);
		
		add(regularButton);
		add(adminButton);
		
		this.setSize(300, 200);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
