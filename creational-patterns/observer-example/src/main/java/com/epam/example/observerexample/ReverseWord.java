package com.epam.example.observerexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class ReverseWord implements Observer {

	@Override
	public void handleWord(String word) {
		String reverseWord = new StringBuilder(word).reverse().toString();
		log(reverseWord);
	}
	
	private void log(String word) {
		System.out.println("Reversed word \"" + word + "\"");
	}
}
