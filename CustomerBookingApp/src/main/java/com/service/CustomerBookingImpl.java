package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerBookingDao;
import com.entities.CustomerBooking;

@Service
public class CustomerBookingImpl implements CustomerBookingService{
	
	@Autowired
	CustomerBookingDao repository;


	public String saveBooking(CustomerBooking booking) {
		return repository.saveBooking(booking);
	}


	public List<CustomerBooking> fetchBookings() {
		return repository.fetchBooking();
	}


	public CustomerBooking fetchBookingsById(int bookingId) {
		return repository.fetchBookingByID(bookingId);
	}


	public String deleteBookingsById(int bookingId) {
		return repository.deleteBookingByID(bookingId);
	}


	public String updateBookings(CustomerBooking booking) {
		return repository.updateBooking(booking);
	}

}
