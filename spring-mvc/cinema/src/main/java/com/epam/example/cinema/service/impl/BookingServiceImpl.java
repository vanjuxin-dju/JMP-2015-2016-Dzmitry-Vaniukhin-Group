package com.epam.example.cinema.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.example.cinema.domain.Booking;
import com.epam.example.cinema.domain.Person;
import com.epam.example.cinema.repository.BookingDao;
import com.epam.example.cinema.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDao bookingRepository;

	@Override
	public List<Booking> getBookingsOfPerson(Person person) {
		return bookingRepository.findByPerson(person);
	}

	@Override
	public void createBooking(String film, Calendar time, Integer place,
			Double cost, Person person) {
		Booking booking = new Booking();
		booking.setFilm(film);
		booking.setTime(time);
		booking.setPlace(place);
		booking.setCost(cost);
		booking.setPerson(person);
		bookingRepository.create(booking);
	}

	@Override
	public void updateBooking(Booking booking) {
		bookingRepository.update(booking);
	}

	@Override
	public Booking getBookingById(Integer id) {
		return bookingRepository.findById(id);
	}

	@Override
	public List<Booking> getBookingsByTime(Calendar time) {
		return bookingRepository.findByTime(time);
	}

	@Override
	public void deleteBooking(Integer id) {
		bookingRepository.deleteById(id);
	}

}
