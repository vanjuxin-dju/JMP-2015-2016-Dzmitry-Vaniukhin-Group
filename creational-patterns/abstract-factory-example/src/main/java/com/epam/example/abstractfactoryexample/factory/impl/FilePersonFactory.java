package com.epam.example.abstractfactoryexample.factory.impl;

import java.io.FileNotFoundException;
import java.util.List;

import com.epam.example.abstractfactoryexample.domain.Person;
import com.epam.example.abstractfactoryexample.drivers.FileDriver;
import com.epam.example.abstractfactoryexample.factory.PersonFactory;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class FilePersonFactory implements PersonFactory {
	
	@Override
	public List<Person> readPeople() throws Exception {
		try {
			return FileDriver.getInstance().getPeople();
		} catch (FileNotFoundException e) {
			throw new Exception("Cannot get people: " + e.getMessage(), e);
		}
	}

	@Override
	public void writePerson(Person person) {
		
	}

	@Override
	public Person readPerson(String name) throws Exception {
		try {
			return FileDriver.getInstance().getPersonByName(name);
		} catch (FileNotFoundException e) {
			throw new Exception("Cannot get person: " + e.getMessage(), e);
		}
	}

}
