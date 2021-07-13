package com.training;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import com.training.model.Customer;
import com.training.model.CustomerRepositoryImp;
import com.training.utils.DbConnection;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = DbConnection.getOracleConnection();
		
		CustomerRepositoryImp dao = new CustomerRepositoryImp(con);
		
		int ch=2;
		try {
			
			if(ch==1) {
				dao.add(new Customer(3,"Ramesh","ram@gmail.com"));
				dao.add(new Customer(4,"Samesh","sam@gmail.com"));
				
			}
			
			if(ch==2) {
				List<Customer> list = dao.findAll();
				for(Customer eachCustomer :list) {
					System.out.println(eachCustomer);
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}

	}


