package com.mapping.concept.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.concept.repo.CollegeRepo;
import com.mapping.concept.repo.PersonAddressRepo;
import com.mapping.concept.repo.PersonRepo;

@RestController
@RequestMapping("/add")
public class PersonController {
	
	@Autowired
	private PersonRepo repoPerson;
	
	@Autowired
	private PersonAddressRepo repo;
	
	@Autowired
	private CollegeRepo reppClg;
	

	
	
	@PostMapping
	public void addd() {
	
		  Person per=new Person("anand",18);
		
		  
		  PersonAddress add1=new PersonAddress("5/56", "TSi");
		  PersonAddress add2=new PersonAddress("5/56", "TSi");

		  
		 
//		  per.getListOfaddress().add(add2);
//		  per.getListOfaddress().add(add1);    //ANOTHER WAY
			List<Person> comments1 = new ArrayList<>();

			List<PersonAddress> comments = new ArrayList<>();
			comments.add(add2);
			comments.add(add1);
			per.setListOfaddress(comments);
		  repoPerson.save(per);
         
	}
	

	
	
	@PutMapping("/{id}")
	public Person add_one_mor_address(@PathVariable int id,@RequestBody PersonAddress adress) {
		
		
		Person obkk=repoPerson.getById(id);
		obkk.getListOfaddress().add(adress);
		Person obj=	repoPerson.save(obkk);
		
		return obj;
		
		
	}
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		Person obj=repoPerson.getById(id);
		System.out.println(obj.getAge());
		return obj;
	}
	
	///COLLEGEES     
	
	@PostMapping("/clg")
	public College add_college() {
		College clg=new College("PEC");
		College clg1=reppClg.save(clg);
		return clg1;
	}
	
	@GetMapping("/clg/{id}")
	public College get_college(@PathVariable int id) {
		College clg1=reppClg.getById(id);
		
		return clg1;
	}
	
	@PutMapping("/clg/addstu/{id}")
	public College add_students(@PathVariable int id) {
		College clg1=reppClg.getById(id);

		  Person per=new Person("akila",23);
		  Person per1=new Person("ak",24);
		  clg1.getListoffStudent().add(per1);
		  clg1.getListoffStudent().add(per);
		  College clg4=reppClg.save(clg1);

		  return clg4;


	}
	
	//   1. ADD COLLEGE
	//   2. ADD STUDENTS
	//   3. ADD STUDENT ADDRESS
	
	

}
