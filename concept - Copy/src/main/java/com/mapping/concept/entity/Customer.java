package com.mapping.concept.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int custId;
	
	
	public Customer() {
		
	}
	public Customer(String name) {
		super();
		this.name = name;
	}

	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="customer_item",
	joinColumns= {	@JoinColumn(name="cust_id")},
	inverseJoinColumns = {@JoinColumn(name="item_id")}	)
    private Item item;
}
