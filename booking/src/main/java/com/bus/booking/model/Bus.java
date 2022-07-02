package com.bus.booking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;


@Entity
@Table
@Data
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	
	@Column
	private String busNo;
	@Column
	private int noOfSeat;
	@Column
	private int availSeat;
	@Column 
	private int bookedSeat=0;
	@Column
    private int prizePerPerson;
	
	@Column
    private int totalCollection=0;
	
	@Column 
	private String busAvailStatus="AVAIL";
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="busid")
	private List<Ticket> ticketList=new ArrayList<Ticket>();

	public void addTicket(Ticket ticket) {
		this.ticketList.add(ticket);
		
	}
	
	
	
}
