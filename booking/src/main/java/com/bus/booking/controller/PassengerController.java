package com.bus.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.booking.exception.AlreadyHaveBus;
import com.bus.booking.model.Ticket;
import com.bus.booking.service.TicketService;



@RestController
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/viewticket/{pnr}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
   public ResponseEntity<Ticket> viewTicket(@PathVariable int pnr){
		Ticket ticket=ticketService.getTicketByPnr(pnr);
		
		if(ticket==null) {
			throw new AlreadyHaveBus("No Ticket Found With PNR: "+pnr);
		}
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
		
	}
	
	@PutMapping("/cancel/{pnr}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
     public ResponseEntity<Ticket> cancelAllPassenger(@PathVariable int pnr){
		
		Ticket ticket=ticketService.getTicketByPnr(pnr);
		
		if(ticket==null) {
			throw new AlreadyHaveBus("No Ticket Found With PNR: "+pnr);
		}
		else {
			if(ticket.getStatus().equalsIgnoreCase("CanCelledAll")){
				throw new AlreadyHaveBus("AlreadyCancelled Ticket With PNR: "+pnr);
			}
			
				Ticket cancelledTicket=ticketService.cancelTicketForAllPassenger(pnr,ticket);
				return new ResponseEntity<Ticket>(cancelledTicket,HttpStatus.OK);
			}
		}
	
	@PutMapping("/cancelTicket/{pnr}/{passenegrid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Ticket> cancelTicketForPassenger(@PathVariable int pnr,@PathVariable("passenegrid") int id){
		
		Ticket ticket=ticketService.getTicketByPnr(pnr);
		if(ticket==null) {
			throw new AlreadyHaveBus("No Ticket Found With PNR: "+pnr);
		}
		else {
			if(ticket.getStatus().equalsIgnoreCase("CanCelledAll")){
				throw new AlreadyHaveBus("AlreadyCancelled Ticket With PNR: "+pnr);
			}
			
				Ticket passengerCancel=ticketService.cancelTicketForPerticularPassenger(pnr,id);
				return new ResponseEntity<Ticket>(passengerCancel,HttpStatus.OK);
			
			
		}
		
		
	}
	
	
	
	

}
