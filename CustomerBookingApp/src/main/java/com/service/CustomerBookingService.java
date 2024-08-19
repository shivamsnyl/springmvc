package com.service;

import java.util.List;

import com.entities.CustomerBooking;

public interface CustomerBookingService {
	
	public String saveBooking(CustomerBooking booking);
	public List<CustomerBooking> fetchBookings();
	public CustomerBooking fetchBookingsById(int bookingId);
	public String deleteBookingsById(int bookingId);
	public String updateBookings(CustomerBooking booking);
	
}
