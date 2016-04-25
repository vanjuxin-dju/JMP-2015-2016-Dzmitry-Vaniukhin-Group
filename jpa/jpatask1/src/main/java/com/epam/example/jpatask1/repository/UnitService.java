package com.epam.example.jpatask1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask1.domain.Unit;
import com.epam.example.jpatask1.repository.base.GenericDao;

public class UnitService implements GenericDao<Unit, Long> {
	@PersistenceContext(name = "UnitService")
	private EntityManager em;
	
	@Override
	public Long create(Unit object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		Unit e = em.find(Unit.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(Unit persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public Unit update(Unit object) {
		em.refresh(object);
		return object;
	}

	@Override
	public Unit findById(Long id) {
		return em.find(Unit.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unit> findAll() {
		Query query = em.createQuery("SELECT * FROM Unit");
		return (List<Unit>) query.getResultList();
	}

}
