package com.epam.example.abstractfactoryexample.factory.impl;

import java.sql.SQLException;
import java.util.List;

import com.epam.example.abstractfactoryexample.domain.Person;
import com.epam.example.abstractfactoryexample.drivers.DBDriver;
import com.epam.example.abstractfactoryexample.factory.PersonFactory;

public class DBPersonFactory implements PersonFactory {

	@Override
	public List<Person> readPeople() throws Exception {
		try {
			return DBDriver.getInstance().getPeople();
		} catch (ClassNotFoundException | SQLException e) {
			throw new Exception("Cannot get people: " + e.getMessage(), e);
		}
	}

	@Override
	public void writePerson(Person person) throws Exception {
		try {
			DBDriver.getInstance().insertPerson(person);
		} catch (ClassNotFoundException | SQLException e) {
			throw new Exception("Cannot write people: " + e.getMessage(), e);
		}
	}

	@Override
	public Person readPerson(String name) throws Exception {
		try {
			return DBDriver.getInstance().getPersonByName(name);
		} catch (ClassNotFoundException | SQLException e) {
			throw new Exception("Cannot get people: " + e.getMessage(), e);
		}
	}

}
