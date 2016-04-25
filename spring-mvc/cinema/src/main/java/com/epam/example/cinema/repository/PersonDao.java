package com.epam.example.cinema.repository;

import com.epam.example.cinema.domain.Person;
import com.epam.example.cinema.repository.base.GenericDao;

public interface PersonDao extends GenericDao<Person, Integer> {
	Person findByCredentials(String email, String password);
}
