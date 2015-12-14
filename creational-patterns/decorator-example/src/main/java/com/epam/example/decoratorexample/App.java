package com.epam.example.decoratorexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {
	private static final String PATH_TO_READ = "d:\\people.txt";
	private static final String PATH_TO_WRITE = "d:\\people2.txt";

	public static void main(String[] args) throws FileNotFoundException {
		PersonInputStream personIS = new PersonInputStream(new FileInputStream(new File(PATH_TO_READ)));
		PersonOutputStream personOS = new PersonOutputStream(new FileOutputStream(new File(PATH_TO_WRITE)));
		try {
			while (true) {
				Person person = personIS.readPerson();
				System.out.println(person.getName() + "\t" + person.getAge());
				personOS.writePerson(person);
			}
		} catch (Exception e) {
			
		} finally {
			personIS.close();
			personOS.close();
		}
	}

}
