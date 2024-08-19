package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.entities.CustomerBooking;


public class CustomerBookingDao {
	

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public String saveBooking(CustomerBooking booking) {
		hibernateTemplate.save(booking);
		return ("Saved Customer booking with customer booking id:: "+ booking.getCustomerID());
	}
	
	public List<CustomerBooking> fetchBooking() {
		List<CustomerBooking> loadAll = hibernateTemplate.loadAll(CustomerBooking.class);
		return loadAll;
	}
	
	public CustomerBooking fetchBookingByID(int bookingId) {
		return hibernateTemplate.get(CustomerBooking.class, bookingId);
	}
	
	@Transactional
	public String deleteBookingByID(int bookingId) {
		CustomerBooking customerBooking = hibernateTemplate.get(CustomerBooking.class, bookingId);
		hibernateTemplate.delete(customerBooking);
		return "Student with Booking id ::" + customerBooking.getBookingID() + " deleted successfully.";
	}
	
	@Transactional
	public String updateBooking(CustomerBooking booking) {	
		hibernateTemplate.saveOrUpdate(booking);
		return "Student with Booking id ::" + booking.getBookingID() + " updated successfully.";
	}

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
