package com.epam.example.junittask1;

import java.util.Scanner;

/**
 * @author sokol
 *
 */
public class App {
	public static void main(String[] args) {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Try to guess the word!");
		System.out.println("Hint: " + game.getMyWord());
		System.out.println("Try count: " + game.getTries());
		while (game.getTries() > 0) {
			System.out.print("Enter a letter: ");
			String line = scanner.nextLine();
			if (game.guessLetter(line.charAt(0))) {
				System.out.println("Yes!");
			} else {
				System.out.println("No!");
			}
			if (game.getWord().equals(game.getMyWord())) {
				break;
			}
			System.out.println("Try count: " + game.getTries());
			System.out.println("Hint: " + game.getMyWord());
		}
		if (game.getTries() == 0) {
			System.out.println("You lose! The word is: " + game.getWord());
		} else {
			System.out.println("You win! The word is: " + game.getWord());
		}
		scanner.close();
	}

}
