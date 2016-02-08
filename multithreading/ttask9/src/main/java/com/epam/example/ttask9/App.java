package com.epam.example.ttask9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		int size = 70;
		List<Integer> list = new ArrayList<>(size);
		System.out.println("Values:");
		for (int i = 0; i < size; i++) {
			int value = (int)(Math.random() * 1200);
			list.add(value);
			System.out.print(value + " ");
		}
		System.out.println();
		
		QuickSort qs = new QuickSort(list);
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(qs);
		
		System.out.println("\nResult:");
		for (int value : list) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
