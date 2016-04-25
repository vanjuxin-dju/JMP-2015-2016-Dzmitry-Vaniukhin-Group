package com.epam.example.cinema.repository;

import java.util.Calendar;
import java.util.List;

import com.epam.example.cinema.domain.Booking;
import com.epam.example.cinema.domain.Person;
import com.epam.example.cinema.repository.base.GenericDao;

public interface BookingDao extends GenericDao<Booking, Integer> {
	List<Booking> findByPerson(Person person);
	
	List<Booking> findByTime(Calendar time);
}
