package com.sts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sts.binding.Passenger;
import com.sts.binding.Ticket;
import com.sts.service.TicketService;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private TicketService service;
	
	@PostMapping(
			value="/ticket",
			consumes = "application/json",
			produces = "application/json"
			)
	public ResponseEntity<Ticket>bookTicket(@RequestBody Passenger passenger){
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping(value="ticket/{tid}",
			produces = "application/json"
			)
	public ResponseEntity<Ticket>geTicket(@PathVariable Integer tid){
		Ticket t = service.getTicket(tid);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	
	@GetMapping(value="/tickets",
			produces = "application/json"
			)
	public ResponseEntity<List<Ticket>> getAllTickets(){
		List<Ticket> Tickets = service.getAllTickets();
		return new ResponseEntity<>(Tickets,HttpStatus.OK);
		}
	
	@DeleteMapping("tdelete/{tid},")
	public ResponseEntity<Ticket>deleteTicket(@PathVariable Integer tid ){
		Ticket delete = service.deleteTicket(tid);
		return new ResponseEntity<>(delete,HttpStatus.OK);
	}
	@PatchMapping("tup/{tid}"
			)
	public ResponseEntity<Ticket>updateTicket(Integer tid ){
		Ticket update = service.updateTicket(tid);
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
}
