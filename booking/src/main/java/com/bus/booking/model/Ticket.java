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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int pnr;
	@Column
	private String busNo;
	@Column
	private int prize;
	@Column
	private int noOfpassenger;
	@Column
	private int totalPrize;
	@Column
	private int busId;
	@Column 
	private String status="Booked";
	

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ticketId")
	private List<Passenger> passenger=new ArrayList<Passenger>();
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
//	

	
}
