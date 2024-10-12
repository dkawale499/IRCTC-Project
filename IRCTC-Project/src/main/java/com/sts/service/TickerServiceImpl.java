package com.sts.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.binding.Passenger;
import com.sts.binding.Ticket;
import com.sts.repo.TicketRepository;
@Service
public class TickerServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repo;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket  t= new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketStatus("Confirmed");
		Ticket savedticket=repo.save(t);
		return savedticket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		return repo.findById(ticketId).orElseThrow();
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		return repo.findAll();
		
	}

}
