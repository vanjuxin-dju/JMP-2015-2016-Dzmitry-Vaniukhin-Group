package com.epam.example.jpatask1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask1.domain.Project;
import com.epam.example.jpatask1.repository.base.GenericDao;

public class ProjectService implements GenericDao<Project, Long> {
	@PersistenceContext(name = "ProjectService")
	private EntityManager em;

	@Override
	public Long create(Project object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		Project e = em.find(Project.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(Project persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public Project update(Project object) {
		em.refresh(object);
		return object;
	}

	@Override
	public Project findById(Long id) {
		return em.find(Project.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findAll() {
		Query query = em.createQuery("SELECT * FROM Project");
		return (List<Project>) query.getResultList();
	}

}
