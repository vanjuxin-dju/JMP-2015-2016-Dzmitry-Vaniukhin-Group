/**
 * 
 */
package com.epam.example.adapterexample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class ListWrapper<T> {
	private List<T> list;
	
	public ListWrapper() {
		list = new ArrayList<>();
	}
	
	public T pop() throws Exception {
		if (list.size() == 0) {
			throw new Exception("No elements!");
		}
		return list.remove(list.size() - 1);
	}
	
	public void push(T object) {
		list.add(object);
	}
}
