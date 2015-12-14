package com.epam.example.abstractfactoryexample.drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.example.abstractfactoryexample.domain.Person;
import com.epam.example.abstractfactoryexample.domain.impl.PersonImpl;

public class FileDriver {
	private static final String PATH = "d:\\people.txt";
	
	private static FileDriver instance;
	
	public static FileDriver getInstance() {
		if (instance == null) {
			instance = new FileDriver();
		}
		return instance;
	}
	
	private FileDriver() {
		
	}
	
	public List<Person> getPeople() throws FileNotFoundException {
		List<Person> people = new ArrayList<Person>();
		Scanner sc = new Scanner(new File(PATH));
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split("\t");
			Person person = new PersonImpl();
			person.setName(line[0]);
			person.setSurname(line[1]);
			String[] date = line[2].split("-");
			Date date1 = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
			person.setBirthday(date1);
			person.setHomeTown(line[3]);
			people.add(person);
		}
		sc.close();
		return people;
	}
	
	public Person getPersonByName(String name) throws FileNotFoundException {
		Person person = new PersonImpl();
		Scanner sc = new Scanner(new File(PATH));
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split("\t");
			if (line[0].equals(name)) {
				person.setName(line[0]);
				person.setSurname(line[1]);
				String[] date = line[2].split("-");
				Date date1 = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				person.setBirthday(date1);
				person.setHomeTown(line[3]);
				break;
			}
		}
		sc.close();
		return person;
	}
	
	public void insertPerson(Person person) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(new File(PATH), true));
		pw.println(person.getName() + "\t" + person.getSurname() + "\t" + person.getBirthday() + "\t" + person.getHomeTown());
		pw.close();
	}
}
