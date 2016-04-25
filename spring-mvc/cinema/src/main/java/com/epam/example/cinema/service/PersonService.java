package com.epam.example.cinema.service;

import com.epam.example.cinema.domain.Person;

public interface PersonService {
	Person loadPerson(String email, String password);
	
	Person getPersonById(Integer id);
	
	void savePerson(String name, String surname, String email, String password);
	
	void updatePerson(Person person);
}
