package com.bus.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.booking.exception.AlreadyHaveBus;
import com.bus.booking.model.Bus;
import com.bus.booking.repository.BusRepo;



@Service
public class BusService {

	
	@Autowired
	private BusRepo busRepo;
	public Bus addNewBusToDb(Bus newob) {
		Bus busFromDb=busRepo.findByBusNo(newob.getBusNo());
		if(busFromDb==null) {
			Bus newBus=busRepo.save(newob);
			return newBus;
		}
		else{
			throw new AlreadyHaveBus("alredy have enterd bus");
		}
		
		
	}
	public Bus getBusByBusNo(String busNo) {
		Bus getBus=busRepo.findByBusNo(busNo);
		if(getBus==null) {
			throw new AlreadyHaveBus("Not Found");
		}
		return getBus;
	}
	
	public List<Bus> getAllBus() {
		
		ArrayList<Bus>partsDetails=(ArrayList<Bus>) busRepo.findAll();
		return partsDetails;

		
	}
	

}
