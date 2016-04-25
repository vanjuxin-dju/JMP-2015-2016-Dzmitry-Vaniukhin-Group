package com.epam.example.jpatask4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask4.domain.User;
import com.epam.example.jpatask4.repository.base.GenericDao;

public class UserService implements GenericDao<User, Long> {
	@PersistenceContext(name = "UserService")
	private EntityManager em;

	@Override
	public Long create(User object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		User e = em.find(User.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(User persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public User update(User object) {
		em.refresh(object);
		return object;
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Query query = em.createQuery("SELECT * FROM Users");
		return (List<User>) query.getResultList();
	}


}
