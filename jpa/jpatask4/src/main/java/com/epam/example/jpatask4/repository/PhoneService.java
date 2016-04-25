package com.epam.example.jpatask4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask4.domain.Phone;
import com.epam.example.jpatask4.repository.base.GenericDao;

public class PhoneService implements GenericDao<Phone, Long> {
	@PersistenceContext(name = "PhoneService")
	private EntityManager em;
	
	@Override
	public Long create(Phone object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		Phone e = em.find(Phone.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(Phone persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public Phone update(Phone object) {
		em.refresh(object);
		return object;
	}

	@Override
	public Phone findById(Long id) {
		return em.find(Phone.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> findAll() {
		Query query = em.createQuery("SELECT * FROM Phones");
		return (List<Phone>) query.getResultList();
	}

}
