package com.epam.example.gctask6;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = null;
		do {
			System.out.print("\nEnter new string (or just press Enter to exit): ");
			if (scanner.hasNextLine())
				str = scanner.nextLine();
			if (str != null && !str.isEmpty()) {
				System.out.println("The new string is: " + str);
			}
		} while (str != null && !str.isEmpty());
		scanner.close();
	}

}
