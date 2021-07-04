package com.patterns.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patterns.movie.dao.TicketDao;
import com.patterns.movie.bo.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao dao;

	@Override
	public void purchase(Ticket tkt) {
		// Process Payment,mailing ticket code goes here
		//dao.create(tkt);
		
		 com.patterns.movie.model.Ticket ticketModel = new com.patterns.movie.model.Ticket(); 
		 ticketModel.setId(tkt.getId());
		  ticketModel.setMovie(tkt.getMovieName());
		  ticketModel.setScreen(tkt.getScreenNo());
		 ticketModel.setSeat(tkt.getSeatNo());
		 dao.create(ticketModel);
		
		// Email Ticket or Text Message the ticket
	}
}
