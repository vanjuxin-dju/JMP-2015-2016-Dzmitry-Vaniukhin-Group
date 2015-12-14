package com.epam.example.observerexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public interface Observable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}
