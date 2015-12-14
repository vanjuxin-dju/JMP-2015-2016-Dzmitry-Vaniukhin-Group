package com.epam.example.abstractfactoryexample.factory;

import java.util.List;

import com.epam.example.abstractfactoryexample.domain.Person;

public interface PersonFactory {
	void writePerson(Person person) throws Exception;
	
	List<Person> readPeople() throws Exception;

	Person readPerson(String name) throws Exception;
}
