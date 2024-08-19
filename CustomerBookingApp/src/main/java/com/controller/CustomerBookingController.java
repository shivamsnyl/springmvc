package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.CustomerBooking;
import com.service.CustomerBookingService;

@Controller
public class CustomerBookingController {
	
	@Autowired
	CustomerBookingService service;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model m) {
		m.addAttribute("page", "home");
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTodo(Model m) {
		m.addAttribute("page", "add");
		m.addAttribute("custBooking", new CustomerBooking());
		return "home";
	}
	
	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("custBooking") CustomerBooking c, Model m) {
		c.setDate(new Date());
		System.out.println(c);
		String bookingMsg = service.updateBookings(c);
		m.addAttribute("msg",bookingMsg);
		System.out.println(bookingMsg);
		return "redirect:/viewBooking";
	}
	
	@RequestMapping(value = "/viewBooking", method = RequestMethod.GET)
	public String fetchAllBookings(Model m) {
		List<CustomerBooking> fetchBookings = service.fetchBookings();
		m.addAttribute("page", "viewBooking");
		m.addAttribute("allBookings",fetchBookings);
		System.out.println(fetchBookings);
		return "home";
	}
	
	/*@RequestMapping(value = "/viewBookingById/{id}", method = RequestMethod.GET)
	public String fetchBookingsByID(@PathVariable int id) {
		CustomerBooking fetchBookings = service.fetchBookingsById(id);
		System.out.println(fetchBookings);
		return "home";
	}*/
	
	@RequestMapping(value = "/deleteBookingById/{id}")
	public String deleteBookingByID(@PathVariable int id) {
		String msg = service.deleteBookingsById(id);
		System.out.println(msg);
		return "redirect:/viewBooking";
	}
	
	@RequestMapping(value = "/updateBooking/{id}")
	public String updateBooking(@PathVariable int id, Model m) {
		CustomerBooking fetchBookings = service.fetchBookingsById(id);
		System.out.println("fetchBookings:::::" +fetchBookings);
		m.addAttribute("custBooking",fetchBookings);
		m.addAttribute("page", "add");
		return "home";
	}

}
