package com.mapping.concept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.concept.entity.Customer;
import com.mapping.concept.entity.Item;
import com.mapping.concept.repo.CustomerRepo;
import com.mapping.concept.repo.ItemRepo;

@RequestMapping("/controller")
@RestController
public class Controller {
	
	@Autowired
	private CustomerRepo repoCus;
	
	@Autowired
	private ItemRepo repoItem;
	
	@PostMapping("/bidirectional")
	public void addCustomerWithChild() {
		// Item id will be a forignKey ! it ll be stored in customer table ...not item table
		
		
		Customer cus=new Customer("anand");
		Item ite=new Item("phone");
		cus.setItem(ite);
		repoCus.save(cus);
		
		
//		Item ite1=new Item("tv");
//		
//		Customer cu1s=new Customer("tak");
//		
//		ite1.setCustomer(cu1s);
//		cu1s.setItem(ite1);
//		repoItem.save(ite1);

		
	}
	
	@GetMapping("/bidirectional/{id}")
	public Customer getCust(@PathVariable int id) {
		Customer obj=repoCus.getById(id);
		return obj;
		
	}
	
	@GetMapping("/bidirectional2/{id}")
	public Item getItem(@PathVariable int id) {
		Item it=repoItem.getById(id);
		return it;
	}
	

}
