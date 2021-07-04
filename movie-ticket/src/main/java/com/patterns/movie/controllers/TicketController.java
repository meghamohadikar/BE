package com.patterns.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.patterns.movie.dao.TicketDao;
import com.patterns.movie.bo.Ticket;
import com.patterns.movie.service.TicketService;

@Controller
public class TicketController {
	

	/*
	 * @Autowired 
	 * private TicketDao dao;
	 */
	
	@Autowired
	private TicketService service;

	@RequestMapping("/showCreateTicket")
	public String showCreateTicket() {
		return "createTicket"; //return view
	}
	
	@RequestMapping("/createTicket")
	public String createTicket(Ticket ticket, ModelMap modelMap) {
		//dao.create(ticket);
		service.purchase(ticket);
		modelMap.addAttribute("msg", "Ticket Purchased successfully");
		return "createTicket";
	}
}
