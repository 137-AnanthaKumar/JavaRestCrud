package com.mapping.concept.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int itemId;
	
	private String name;
	public Item() {}
	public Item(String name) {
		super();
		this.name = name;
	}
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="item")
	private Customer customer;
	

}
