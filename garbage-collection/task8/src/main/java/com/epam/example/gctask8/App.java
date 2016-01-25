package com.epam.example.gctask8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> list = null;
		while (true) {
			if (list != null) {
				int count = Math.abs(rand.nextInt() % 21);
				System.out.println("The count is: " + count);
				if (count == 0) {
					list = null;
					System.out.println("list is set to null");
				} else {
					for (int i = 0; i < count; i++) {
						int next = rand.nextInt();
						list.add(next);
						System.out.println("Next value is: " + next);
					}
				}
			} else {
				list = new ArrayList<>();
				System.out.println("list is initialised");
			}
		}
	}

}
