package com.training.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.utils.CrudRepository;

public class CustomerRepositoryImp implements CrudRepository<Customer> {
	
	private Connection con;

	public CustomerRepositoryImp(Connection con) {
		super();
		this.con = con;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(Customer t) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1,t.getId());
		pstmt.setString(2, t.getCustomerName());
		pstmt.setString(3, t.getEmail());
		
		int rowAdded = pstmt.executeUpdate();
		
		
		return rowAdded;
	}

	@Override
	public List<Customer> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Customer> custList = new ArrayList<>();
		
		String sql = "select *from customer";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("Id");
			String customerName = rs.getString("customerName");
			String email = rs.getString("email");
			
			custList.add(new Customer(id , customerName , email));
		}
		return custList;
	}

	

	
	
	

	

}
