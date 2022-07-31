package com.mapping.concept.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class College {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int college_Id;
	
	private String name;
	
	  public College() {
		  
	  }
	  public College(String name) {
		super();
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL)
	  @JoinColumn( name = "clg_id", referencedColumnName = "college_Id")
	  List<Person> listoffStudent = new ArrayList<>();

}
