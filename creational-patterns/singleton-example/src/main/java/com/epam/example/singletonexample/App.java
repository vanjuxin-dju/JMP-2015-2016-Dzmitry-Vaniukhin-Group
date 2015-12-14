package com.epam.example.singletonexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Superman superman = Superman.getInstance();
	}

}
