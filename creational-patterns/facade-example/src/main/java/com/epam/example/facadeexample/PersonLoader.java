/**
 * 
 */
package com.epam.example.facadeexample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class PersonLoader {
	private static final String PATH = "d:\\people.txt";
	
	private File file;
	
	public PersonLoader() {
		file = new File(PATH);
	}
	
	public List<Person> loadPeople() {
		List<Person> people = new ArrayList<>();
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String lineSrc = sc.nextLine();
				String[] line = lineSrc.split("\t");
				people.add(new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			//throw new Exception("Cannot load people", e);
		}
		return people;
	}
	
	public void savePerson(Person person) throws Exception {
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			writeToFile(person, writer);
			writer.close();
		} catch (FileNotFoundException e) {
			throw new Exception("Cannot append person", e);
		}
	}
	
	public void storePeople(List<Person> people) throws Exception {
		try {
			PrintWriter writer = new PrintWriter(file);
			for (Person person: people) {
				writeToFile(person, writer);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			throw new Exception("Cannot store people", e);
		}
	}

	private void writeToFile(Person person, PrintWriter writer) {
		//  name	age 	iq
		writer.println(person.getName() + "\t" + person.getAge() + "\t" + person.getIq());
	}
}
