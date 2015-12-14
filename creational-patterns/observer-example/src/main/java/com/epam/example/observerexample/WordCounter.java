package com.epam.example.observerexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class WordCounter implements Observer {
	private int count;
	
	public WordCounter() {
		count = 0;
	}
	
	@Override
	public void handleWord(String word) {
		count++;
		log(word);
	}
	
	private void log(String word) {
		System.out.println("Found new word \"" + word + "\". Count is set to " + count);
	}

}
