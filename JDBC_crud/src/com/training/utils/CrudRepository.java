package com.training.utils;

import java.sql.*;
import java.util.*;

import com.training.model.Customer;
public interface CrudRepository<T> {
	
	public int add(T t) throws SQLException;
	public List<T> findAll() throws Exception;
	//Customer findById(int key) throws SQLException;

}
