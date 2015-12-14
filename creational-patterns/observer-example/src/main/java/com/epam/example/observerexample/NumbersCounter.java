package com.epam.example.observerexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class NumbersCounter implements Observer {
	private int count;
	
	public NumbersCounter() {
		count = 0;
	}

	@Override
	public void handleWord(String word) {
		try {
			@SuppressWarnings("unused")
			double number = Double.parseDouble(word);
			
			count++;
			log(word);
		} catch (Exception e) {
		}

	}
	
	private void log(String word) {
		System.out.println("Found new number \"" + word + "\". Count is set to " + count);
	}

}
