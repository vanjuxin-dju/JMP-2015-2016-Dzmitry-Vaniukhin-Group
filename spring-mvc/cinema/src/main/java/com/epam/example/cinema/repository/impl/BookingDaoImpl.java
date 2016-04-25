package com.epam.example.cinema.repository.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.example.cinema.domain.Booking;
import com.epam.example.cinema.domain.Person;
import com.epam.example.cinema.repository.BookingDao;
import com.epam.example.cinema.repository.base.AbstractHibernateDao;

@Repository
@Transactional
public class BookingDaoImpl extends AbstractHibernateDao<Booking, Integer> implements
		BookingDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findByPerson(Person person) {
		Criteria qr = getSession()
				.createCriteria(Booking.class, "Booking")
				.add(Restrictions.eq("person", person))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return qr.list(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findByTime(Calendar time) {
		Criteria qr = getSession()
				.createCriteria(Booking.class, "Booking")
				.add(Restrictions.eq("time", time))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return qr.list(); 
	}

	

}
