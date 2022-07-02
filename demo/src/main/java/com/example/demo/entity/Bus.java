package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	
	
	
}
