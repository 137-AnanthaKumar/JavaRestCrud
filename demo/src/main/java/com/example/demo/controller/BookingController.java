package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ticket;
import com.example.demo.exception.AlreadyHaveBus;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/bookBus")
public class BookingController {
   @Autowired
   private TicketService ticketService;
	
	@PostMapping
	public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket){
		
		Ticket bookedTicket=ticketService.bookNewTicket(ticket);
		if(bookedTicket!=null) {
			return new ResponseEntity<Ticket>(bookedTicket,HttpStatus.OK);
		}
		else  {
			throw new AlreadyHaveBus("Something wrong Please Try again Later");
		}
		
		
		
		
	}
}
