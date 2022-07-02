package com.example.sample_mapping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Branch {
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	    @OneToMany(targetEntity=Branch.class,cascade = CascadeType.ALL, 
	               fetch = FetchType.LAZY, orphanRemoval = true)
	    @JoinColumn(name = "companyId", referencedColumnName = "id")
	    private List<Branch> branches = new ArrayList<>();

}
