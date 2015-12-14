package com.epam.example.iteratorexample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LIFOIterator<E> implements Iterator<E> {
	private List<E> list;
	private int index;
	
	public LIFOIterator() {
		list = new ArrayList<>();
		index = list.size();
	}
	
	public LIFOIterator(List<E> list) {
		this.list = list;
		index = list.size();
	}

	@Override
	public boolean hasNext() {
		return index > 0;
	}

	@Override
	public E next() {
		if (hasNext()) {
			index--;
			return list.get(index);
		} else {
			throw new NoSuchElementException("Stack is already iterated!");
		}
	}

}
