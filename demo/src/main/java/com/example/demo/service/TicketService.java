package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bus;
import com.example.demo.entity.Passenger;
import com.example.demo.entity.Ticket;
import com.example.demo.exception.AlreadyHaveBus;
import com.example.demo.repo.BusRepo;
import com.example.demo.repo.PassengerRepo;
import com.example.demo.repo.TicketRepo;


@Service
public class TicketService {

	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private PassengerRepo passengerRepo;


	
	public Ticket bookNewTicket(Ticket ticket) {
		Ticket savingTicket=new Ticket();
		Bus busFromDb=busRepo.findByBusNo(ticket.getBusNo());
		
		List passengers=ticket.getPassenger();
		int noOfpassenger=passengers.size();
		
		List<Ticket> ticketsDp=ticketRepo.findAll();
		int lengthOfTicket=ticketsDp.size();
		System.out.println("lengthOfTicket"+lengthOfTicket);
		
		
		

		if(busFromDb!=null) {
			if(noOfpassenger==busFromDb.getAvailSeat() || noOfpassenger<busFromDb.getAvailSeat()) {
				System.out.println("Line 1");
				
				int newAvailable=busFromDb.getAvailSeat()-noOfpassenger;
				int newBookedSeat=busFromDb.getBookedSeat()+noOfpassenger;
				busFromDb.setAvailSeat(newAvailable);
				busFromDb.setBookedSeat(newBookedSeat);
				
				int totalCalection=((busFromDb.getPrizePerPerson()*noOfpassenger)+busFromDb.getTotalCollection());
				busFromDb.setTotalCollection(totalCalection);
				
				if(busFromDb.getBookedSeat()==busFromDb.getNoOfSeat()) {
					busFromDb.setBusAvailStatus("FULL");
				}
				
				busRepo.save(busFromDb);
				int pnrCode=500;
				int a=pnrCode+lengthOfTicket;
				ticket.setPnr(pnrCode+lengthOfTicket);

				Ticket storingTicket=new Ticket();
				storingTicket.setBusId(busFromDb.getBusId());
				
				storingTicket.setPnr(a);
				storingTicket.setBusNo(ticket.getBusNo());
				
				
				for(Passenger passenger:ticket.getPassenger()) {
					passenger.setPassengerStatus("CNF");
					
				}
				storingTicket.setPassenger(ticket.getPassenger());
					
//					for(PartsEntity partentity:partsDetails) {
//						float quen=partentity.getQuentity();
//						int PartPrize=(int) (quen*partentity.getAmountOfPart());
//						partentity.setPrize(PartPrize);
//						prize.add(PartPrize);
//						
//			       }
				
				storingTicket.setPrize(busFromDb.getPrizePerPerson());
				
				
				storingTicket.setNoOfpassenger(noOfpassenger);
				int totalPrize=(busFromDb.getPrizePerPerson())*noOfpassenger;
				
				storingTicket.setTotalPrize(totalPrize);
				return	ticketRepo.save(storingTicket);

				
			}
			else if(busFromDb.getAvailSeat()==0) {
				throw new AlreadyHaveBus("Bus Full");
			}
			else if(noOfpassenger>busFromDb.getAvailSeat()) {
				throw new AlreadyHaveBus("Only "+busFromDb.getAvailSeat()+" Left");
			}
		
		}
		
		else if(busFromDb==null) {
			throw new AlreadyHaveBus("No Bus Found");
		}
		
		return null;
		}



	public Ticket getTicketByPnr(int pnr) {
		Ticket ticket=ticketRepo.findByPnr(pnr);
		if(ticket==null) {
			return null;
		}
		else {
			return ticket;
		}
		
	}

//----------------------------------------------------------------------------------------------

	public Ticket cancelTicketForAllPassenger(int pnr, Ticket ticket) {
		Ticket toCancelTicket=ticketRepo.findByPnr(pnr);
		toCancelTicket.setStatus("CanCelledAll");
		for(Passenger passenger:ticket.getPassenger()) {
			passenger.setPassengerStatus("CAN");
			
		}
		
		// Update Bus
		Bus toUpdatebus=busRepo.getById(toCancelTicket.getBusId());
		toUpdatebus.setAvailSeat(toUpdatebus.getAvailSeat()+toCancelTicket.getNoOfpassenger());
		toUpdatebus.setBookedSeat(toUpdatebus.getBookedSeat()-toCancelTicket.getNoOfpassenger());
		toUpdatebus.setBusAvailStatus("AVAIL");
		busRepo.save(toUpdatebus);
		
		
		Ticket canCelledTicket=ticketRepo.save(toCancelTicket);
		return canCelledTicket;
	}

//---------------------------------------------------------------------------------------------------------------

	public Ticket cancelTicketForPerticularPassenger(int pnr, int id) {
		Ticket toCancelTicketForPassenger=ticketRepo.findByPnr(pnr);

		List<Passenger>updatedpassenger=toCancelTicketForPassenger.getPassenger();

		boolean flag=false;
		
		for(Passenger partentity:updatedpassenger ) {
			if(partentity.getPassengerid()==id && partentity.getPassengerStatus().equalsIgnoreCase("CNF")) {
				flag=true;
				partentity.setPassengerStatus("CAN");
				
				
			}
			else if(partentity.getPassengerid()==id && partentity.getPassengerStatus().equalsIgnoreCase("CAN")){
				throw new AlreadyHaveBus("Alrady Canceled For This Passenger "+partentity.getName());
			}
			
			
			
			
			
	 }
		boolean allPassengerCancelled=false;
		
		for(Passenger partentity:updatedpassenger ) {
			if(partentity.getPassengerStatus().equalsIgnoreCase("CAN")) {
				allPassengerCancelled=true;
				
			}
			else {
				allPassengerCancelled=false;
			}
		}
		
		
		
		if(flag==true) {
			Bus toUpdatebus=busRepo.getById(toCancelTicketForPassenger.getBusId());
			toUpdatebus.setAvailSeat(toUpdatebus.getAvailSeat()+1);
			toUpdatebus.setBookedSeat(toUpdatebus.getBookedSeat()-1);
			toUpdatebus.setBusAvailStatus("AVAIL");
			busRepo.save(toUpdatebus);
			
			
			toCancelTicketForPassenger.setPassenger(updatedpassenger);
			toCancelTicketForPassenger.setStatus("CAN-BOOK");
			if(allPassengerCancelled) {
				toCancelTicketForPassenger.setStatus("CANCELLED");
			}
			ticketRepo.save(toCancelTicketForPassenger);
		}
		else {
			
				throw new AlreadyHaveBus("No Passenger Found");
			
		}
		
		return toCancelTicketForPassenger;

		
	}



	public List<Ticket> getAllPassengerByBus(String busNo) {
		ArrayList<Ticket>partsDetails=ticketRepo.findAllByBusNo(busNo);
		return partsDetails;
	}
	
	
	
	
	
	

}

