package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

public class CustomerService {

	private List<Customer> custList;
	
	public CustomerService() {
		super();
		custList = new ArrayList<Customer>();
		init();
	}
	private void init() {
		
		this.custList.add(new Customer(101,"Suresh",258423));
		this.custList.add(new Customer(108,"Kuresh",258453));
	}
	
	public boolean add(Customer cust) {
		return this.custList.add(cust);
	}
	public List<Customer> getAllCustomer(){
		//init();
		return this.custList;
	}
	public Customer getCustomerById(int id) {
		Customer cust = null;
		Optional<Customer> resp = this.custList.stream().filter(c-> c.getCustomerId()==id).findFirst();
		if(resp.isPresent()) {
			cust=resp.get();
		}else {
			throw new RuntimeException("Element not found");
		}
		return cust;
	}
}
