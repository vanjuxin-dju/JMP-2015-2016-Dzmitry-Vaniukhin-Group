package com.epam.example.junittask1;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	@Test
	public void testCountOfTriesShouldEqual10() {
		Game game = new Game();
		Assert.assertEquals(10, game.getTries());
	}
	
	@Test
	public void testMyWordShouldEqual___() {
		Game game = new Game();
		Assert.assertNotNull(game.getWord());
		Assert.assertNotNull(game.getMyWord());
		String myWord = game.getMyWord();
		for (int i = 0; i < myWord.length(); i++) {
			Assert.assertEquals(myWord.charAt(i), '_');
		}
	}
	
	@Test
	public void testIfWordDoesNotHaveMyLettersThenCountOfTriesReduces() {
		Game game = new Game();
		Assert.assertNotNull(game.getWord());
		Assert.assertNotNull(game.getMyWord());
		char letter = getNotSuitableLetter(game.getWord());
		Assert.assertFalse(game.guessLetter(letter));
		Assert.assertEquals(9, game.getTries());
	}
	
	@Test
	public void testIfWordDoesHaveMyLettersThenMyWordGetsChanged() {
		Game game = new Game();
		Assert.assertNotNull(game.getWord());
		Assert.assertNotNull(game.getMyWord());
		char letter = getSuitableLetter(game.getWord());
		Assert.assertTrue(game.guessLetter(letter));
		Assert.assertEquals(10, game.getTries());
		Assert.assertTrue(game.getMyWord().contains(Character.toString(letter)));
	}
	
	private char getNotSuitableLetter(String word) {
		char letter = 'a';
		while (word.contains(Character.toString(letter))) {
			letter++;
			if (letter == 'z')
				throw new RuntimeException("Out of letters!");
		}
		return letter;
	}
	
	private char getSuitableLetter(String word) {
		char letter = 'a';
		while (!word.contains(Character.toString(letter))) {
			letter++;
		}
		return letter;
	}
}
