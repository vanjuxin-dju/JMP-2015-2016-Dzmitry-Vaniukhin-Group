package com.epam.example.jpatask2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask2.domain.Account;
import com.epam.example.jpatask2.repository.base.GenericDao;

public class AccountService implements GenericDao<Account, Long> {
	@PersistenceContext(name = "AccountService")
	private EntityManager em;

	@Override
	public Long create(Account object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		Account e = em.find(Account.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(Account persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public Account update(Account object) {
		em.refresh(object);
		return object;
	}

	@Override
	public Account findById(Long id) {
		return em.find(Account.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findAll() {
		Query query = em.createQuery("SELECT * FROM Account");
		return (List<Account>) query.getResultList();
	}

}
