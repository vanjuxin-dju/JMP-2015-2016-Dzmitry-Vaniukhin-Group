package com.epam.example.junittask1;

public class Game {
	private static final String[] WORDS = { // The list of words can be expanded
			"world",
			"hello",
			"light",
			"water"
	};
	
	private int tries;
	
	private String word;
	
	private String myWord;
	
	public Game() {
		tries = 10;
		word = WORDS[(int)(Math.random() * WORDS.length)];
		StringBuilder sb = new StringBuilder(word.length());
		for (int i = 0; i < word.length(); i++) {
			sb.append("_");
		}
		myWord = sb.toString();
	}
	
	public boolean guessLetter(char letter) {
		boolean contains = word.contains(Character.toString(letter));
		if (contains) {
			for (int i = 0; i < myWord.length(); i++) {
				if (word.charAt(i) == letter)
					replaceCharInMyWord(i, letter);
			}
		} else {
			tries--;
		}
		return contains;
	}

	public int getTries() {
		return tries;
	}

	public String getWord() {
		return word;
	}

	public String getMyWord() {
		return myWord;
	}
	
	private void replaceCharInMyWord(int pos, char c) {
		myWord = myWord.substring(0, pos) + c + myWord.substring(pos + 1);
	}
}
