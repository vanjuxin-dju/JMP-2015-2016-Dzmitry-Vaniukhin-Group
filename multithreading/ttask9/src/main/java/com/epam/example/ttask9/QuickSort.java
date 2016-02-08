package com.epam.example.ttask9;

import java.util.List;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class QuickSort extends RecursiveAction {
	private List<Integer> list;
	private int left;
	private int right;

	public QuickSort(List<Integer> list) {
		this.list = list;
		this.left = 0;
		this.right = list.size() - 1;
	}
	
	public QuickSort(List<Integer> list, int left, int right) {
		this.list = list;
		this.left = left;
		this.right = right;
	}

	@Override
	protected void compute() {
		if (left < right) {
			int middle = left + (right - left) / 2;
			middle = processPartition(middle);
			
			invokeAll(new QuickSort(list, left, middle - 1), new QuickSort(list, middle + 1, right));
		}
	}
	
	private int processPartition(int middle) {
		int middleElem = list.get(middle);
		swap(middle, right);
		
		int index = left;
		for (int i = left; i < right; i++) {
			if (list.get(i).compareTo(middleElem) < 0) {
				swap(i, index);
				index++;
			}
		}
		
		swap(index, right);
		return index;
	}
	
	private void swap(int i, int j) {
		if (i != j) {
			int iVal = list.get(i);
			list.set(i, list.get(j));
			list.set(j, iVal);
		}
	}

}
