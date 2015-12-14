/**
 * 
 */
package com.epam.example.decoratorexample;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class PersonInputStream {
	private InputStream inputStream;
	private Scanner scanner;
	
	public PersonInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
		scanner = new Scanner(this.inputStream);
	}
	
	public Person readPerson() throws Exception {
		if (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split("\t");
			return new Person(line[0].toLowerCase(), new Integer(line[1]));
		} else {
			throw new Exception("No more people!");
		}
	}
	
	public void close() {
		scanner.close();
	}
}
