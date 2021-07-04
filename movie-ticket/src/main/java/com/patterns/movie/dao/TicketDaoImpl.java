package com.patterns.movie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.patterns.movie.model.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String sql="insert into TICKET(MOVIE,SCREEN,SEAT) values(?,?,?)";

	@Override
	public void create(Ticket tkt) {
		
		jdbcTemplate.update(sql,tkt.getMovie(),tkt.getScreen(),tkt.getSeat());

	}

}
