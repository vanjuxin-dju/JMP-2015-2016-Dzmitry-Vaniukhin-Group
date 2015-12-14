package com.epam.example.facadeexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		Facade facade = new Facade();
		facade.compareIq();
		facade.moveIq();
		facade.incrementIq();
	}

}
