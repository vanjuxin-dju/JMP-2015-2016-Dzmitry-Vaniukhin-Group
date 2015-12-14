package com.epam.example.observerexample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class WordsData implements Observable {
	private List<Observer> observers;
	private String word;
	
	public WordsData() {
		observers = new ArrayList<>();
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer: observers) {
			observer.handleWord(word);
		}
	}

	public void setWord(String word) {
		this.word = word;
		notifyObservers();
	}
}
