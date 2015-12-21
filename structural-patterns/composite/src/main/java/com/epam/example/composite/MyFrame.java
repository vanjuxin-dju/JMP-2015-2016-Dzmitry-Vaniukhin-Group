package com.epam.example.composite;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	private JTree tree;
	
	public MyFrame() {
		super("Tree");
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
		root.add(new DefaultMutableTreeNode("leaf1"));
		
		DefaultMutableTreeNode subtree1 = new DefaultMutableTreeNode("usr");
		DefaultMutableTreeNode subtree2 = new DefaultMutableTreeNode("bin");
		subtree2.add(new DefaultMutableTreeNode("ls"));
		subtree1.add(subtree2);
		root.add(subtree1);
		
		tree = new JTree(root);
		tree.setBounds(0, 0, 300, 200);
		
		add(tree);
		
		this.setSize(300, 240);
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

}
