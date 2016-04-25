package com.epam.example.cinema.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.example.cinema.domain.Person;
import com.epam.example.cinema.repository.PersonDao;
import com.epam.example.cinema.repository.base.AbstractHibernateDao;

@Repository
@Transactional
public class PersonDaoImpl extends AbstractHibernateDao<Person, Integer> implements PersonDao {
	
	@Override
	public Person findByCredentials(String email, String password) {
		Criteria cr = getSession()
				.createCriteria(Person.class, "Person")
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password));
		return (Person) cr.uniqueResult(); 
	}

}
