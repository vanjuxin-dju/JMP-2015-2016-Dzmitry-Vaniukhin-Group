package com.epam.example.jpatask2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask2.domain.Client;
import com.epam.example.jpatask2.repository.base.GenericDao;

public class ClientService implements GenericDao<Client, Long> {
	@PersistenceContext(name = "ClientService")
	private EntityManager em;

	@Override
	public Long create(Client object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		Client e = em.find(Client.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(Client persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public Client update(Client object) {
		em.refresh(object);
		return object;
	}

	@Override
	public Client findById(Long id) {
		return em.find(Client.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		Query query = em.createQuery("SELECT * FROM Client");
		return (List<Client>) query.getResultList();
	}


}
