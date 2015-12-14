package com.epam.example.iteratorexample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1948471586727878402L;
	
	public MyArrayList() {
		super();
	}

	public MyArrayList(Collection<? extends E> c) {
		super(c);
	}

	public MyArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public Iterator<E> iterator() {
		return new LIFOIterator<E>(this);
	}
}
