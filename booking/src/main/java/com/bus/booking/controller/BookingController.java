package com.bus.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.booking.exception.AlreadyHaveBus;
import com.bus.booking.model.Ticket;
import com.bus.booking.service.TicketService;


@RestController
@RequestMapping("/apii/bookBus")
public class BookingController {
   @Autowired
   private TicketService ticketService;
   
  // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	
	@PostMapping("/newTicket")
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
