/**
 * 
 */
package com.epam.example.decorator;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
@SuppressWarnings("serial")
public class AdminButton extends JButton {

	public AdminButton() {
		super();
		init();
	}

	public AdminButton(Action arg0) {
		super(arg0);
		init();
	}

	public AdminButton(Icon icon) {
		super(icon);
		init();
	}

	public AdminButton(String text, Icon icon) {
		super(text, icon);
		init();
	}

	public AdminButton(String text) {
		super(text);
		init();
	}
	
	private void init() {
		final AdminButton self = this;
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				self.setBackground(Color.GRAY);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				self.setBackground(Color.CYAN);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
