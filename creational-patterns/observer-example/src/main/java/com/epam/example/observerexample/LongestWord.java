package com.epam.example.observerexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class LongestWord implements Observer {
	private String maxWord;
	
	public LongestWord() {
		maxWord = "";
	}

	@Override
	public void handleWord(String word) {
		if (maxWord.length() < word.length()) {
			maxWord = word;
			log(word);
		}
	}
	
	private void log(String word) {
		System.out.println("Found new longest word \"" + word + "\"");
	}

}
