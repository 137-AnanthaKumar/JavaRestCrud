package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ticket;
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	Ticket findByPnr(int pnr);

	ArrayList<Ticket> findAllByBusNo(String busNo);

}
