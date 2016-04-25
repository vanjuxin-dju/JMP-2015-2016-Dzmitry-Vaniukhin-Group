package com.epam.example.cinema.service;

import java.util.Calendar;
import java.util.List;

import com.epam.example.cinema.domain.Booking;
import com.epam.example.cinema.domain.Person;

public interface BookingService {
	List<Booking> getBookingsOfPerson(Person person);
	
	void createBooking(String film, Calendar time, Integer place, Double cost, Person person);
	
	void updateBooking(Booking booking);
	
	Booking getBookingById(Integer id);
	
	List<Booking> getBookingsByTime(Calendar time);
	
	void deleteBooking(Integer id);
}
