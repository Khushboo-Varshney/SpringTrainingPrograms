package com.example.demo.customer_jersey_rest;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerResource {
	CustomerService service = new CustomerService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//CustomerService service = new CustomerService();
	public List<Customer> getAllCustomers(){
		
		//CustomerService service = new CustomerService();
		
		return service.getAllCustomer();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerById(@PathParam("id") int id) {
		return service.getCustomerById(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCustomer(Customer cust) {
		
		boolean isAdded = this.service.add(cust);
		
		if(isAdded) {
			return Response.status(201).entity(cust).build();
		}else {
			throw new RuntimeException("Exception");
		}
	}

}
