package com.epam.example.jpatask1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.example.jpatask1.domain.Employee;
import com.epam.example.jpatask1.repository.base.GenericDao;

public class EmployeeService implements GenericDao<Employee, Long> {
	@PersistenceContext(name = "EmployeeService")
	private EntityManager em;

	@Override
	public Long create(Employee object) {
		em.persist(object);
		return object.getId();
	}

	@Override
	public void deleteById(Long id) {
		Employee e = em.find(Employee.class, id);
		if (e != null) {
			em.remove(e);
		}
	}

	@Override
	public void delete(Employee persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public Employee update(Employee object) {
		em.refresh(object);
		return object;
	}

	@Override
	public Employee findById(Long id) {
		return em.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		Query query = em.createQuery("SELECT * FROM Employee");
		return (List<Employee>) query.getResultList();
	}


}
