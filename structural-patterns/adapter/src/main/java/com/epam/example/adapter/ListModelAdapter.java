package com.epam.example.adapter;

import javax.swing.DefaultListModel;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class ListModelAdapter {
	@SuppressWarnings("rawtypes")
	private DefaultListModel listModel;
	
	@SuppressWarnings("rawtypes")
	public ListModelAdapter() {
		listModel = new DefaultListModel();
	}
	
	@SuppressWarnings("unchecked")
	public void addElement(Object element) {
		listModel.addElement(element);
	}
	
	@SuppressWarnings("rawtypes")
	public DefaultListModel getListModel() {
		return listModel;
	}
	
	@SuppressWarnings("unchecked")
	public void moveElements(ListModelAdapter listModel) {
		while (listModel.listModel.size() > 0) {
			this.listModel.addElement(listModel.listModel.remove(0));
		}
	}
}
