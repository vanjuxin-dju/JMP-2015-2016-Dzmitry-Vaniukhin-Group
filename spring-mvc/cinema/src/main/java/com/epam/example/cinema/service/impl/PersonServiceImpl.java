package com.epam.example.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.example.cinema.domain.Person;
import com.epam.example.cinema.repository.PersonDao;
import com.epam.example.cinema.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personRepository;
	
	@Override
	public Person loadPerson(String email, String password) {
		return personRepository.findByCredentials(email, password);
	}

	@Override
	public Person getPersonById(Integer id) {
		return personRepository.findById(id);
	}

	@Override
	public void savePerson(String name, String surname, String email,
			String password) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		person.setEmail(email);
		person.setPassword(password);
		personRepository.create(person);
	}

	@Override
	public void updatePerson(Person person) {
		personRepository.update(person);
	}

}
