package com.epam.example.observerexample;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class App {
	private static final String FILEPATH = "d:\\draft sus.txt";
	public static void main(String[] args) throws IOException {
		String fileContents = new String(Files.readAllBytes(FileSystems.getDefault().getPath(FILEPATH)));
		String[] words = fileContents.split("\\s+");
		WordsData wordsData = new WordsData();
		wordsData.addObserver(new WordCounter());
		wordsData.addObserver(new NumbersCounter());
		wordsData.addObserver(new LongestWord());
		wordsData.addObserver(new ReverseWord());
		for (String word: words) {
			wordsData.setWord(word);
		}
		
	}

}
