/**
 * 
 */
package com.epam.example.singletonexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class Superman {
	private static Superman instance;

	public static Superman getInstance() {
		if (instance == null) {
			instance = new Superman();
		}
		return instance;
	}
	
	private Superman() {
		
	}
}
