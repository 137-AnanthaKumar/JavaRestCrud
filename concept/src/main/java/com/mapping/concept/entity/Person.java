package com.mapping.concept.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
                                                              // No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor 
                                                               //and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: com.mapping.concept.entity.Person$HibernateProxy$1rTGlplu["hibernateLazyInitializer"])

public class Person {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int person_Id;
	   
	   private String name;
	   
	   private int age;
	   
	   public Person() {
		   
	   }
	   public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	   @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn( name = "pc_fid", referencedColumnName = "person_Id")
	  List<PersonAddress> listOfaddress = new ArrayList<>();
}
