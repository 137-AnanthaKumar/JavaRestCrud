package com.bus.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.booking.model.Bus;
import com.bus.booking.model.Ticket;
import com.bus.booking.service.BusService;
import com.bus.booking.service.TicketService;


@RestController
@RequestMapping("/api/bus")
public class BusController {
	
	@Autowired
	private BusService busService;
	@Autowired
	private TicketService ticketService;
	@PostMapping("/addnewbus")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Bus> addNewBus(@RequestBody Bus bus){
		
		Bus newob=new Bus();
		newob.setAvailSeat(bus.getNoOfSeat());
		newob.setBusNo(bus.getBusNo());
		newob.setAvailSeat(bus.getNoOfSeat());
		newob.setPrizePerPerson(bus.getPrizePerPerson());
		newob.setNoOfSeat(bus.getNoOfSeat());
		
		Bus savedBus=busService.addNewBusToDb(newob);
		return new ResponseEntity<Bus>(savedBus,HttpStatus.OK);
		
		
	
	
	}
	
	@GetMapping("/getBus/{busNo}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Bus> getBus(@PathVariable String busNo ){
		
		Bus getBus=busService.getBusByBusNo(busNo);
		return new ResponseEntity<Bus>(getBus,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllBus")
   @PreAuthorize("hasRole('ADMIN')")
    public  List<Bus> getAllBus(){
 		List<Bus>partsDetails=busService.getAllBus();
		return partsDetails;
		
	}
	
	@GetMapping("/getAllPassenger/{busNo}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public  List<Ticket> getAllPassengerForPerticularBus(@PathVariable String busNo){
		List<Ticket>partsDetails=ticketService.getAllPassengerByBus(busNo);
		return partsDetails;
		
	}
	
	

}
