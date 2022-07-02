package com.bus.booking.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.booking.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	Ticket findByPnr(int pnr);

	ArrayList<Ticket> findAllByBusNo(String busNo);

}
