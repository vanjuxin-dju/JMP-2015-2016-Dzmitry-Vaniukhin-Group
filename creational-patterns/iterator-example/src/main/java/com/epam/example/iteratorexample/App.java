package com.epam.example.iteratorexample;

import java.util.Iterator;
import java.util.List;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {

	public static void main(String[] args) {
		List<String> listOfStrings = new MyArrayList<>();
		listOfStrings.add("o");
		listOfStrings.add("l");
		listOfStrings.add("l");
		listOfStrings.add("e");
		listOfStrings.add("H");
		
		Iterator<String> lifoIterator = listOfStrings.iterator();
		while (lifoIterator.hasNext()) {
			System.out.println(lifoIterator.next());
		}
	}

}
