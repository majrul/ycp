package com.cdac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cdac.model.Product;

public class ProductDao {

	public List<Product> fetchDummyProducts(int position, int rows) {
		List<Product> products = new ArrayList<>();
		for(int i=0; i<10000; i++) {
			Product product = new Product();
			product.setId(i + 1);
			product.setName("Nokia 6600");
			product.setPrice(5000);
			product.setQuantity(99);
			products.add(product);
		}
		
		return products.subList(position, position + rows);
	}
	
	public List<Product> fetch(int position, int rows) {
		Connection conn = null;
		PreparedStatement stmt = null; //to help us in executing SQL statements
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@ipaddress:1521:xe", "shyamdada", "radha");

			//TODO : Oracle -> RowNum
			//MySQL -> limit keyword
			String sql = "select * from TBL_PRODUCT limit ?,?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, position);
			stmt.setInt(2, rows);
			
			rs = stmt.executeQuery(); //select queries
			
			List<Product> products = new ArrayList<>();
			while(rs.next()) { //one row at a time
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				products.add(product);
			}
			return products;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null; //insteaad we should have thrown an exception
		}
		finally {
			try { rs.close(); } catch(Exception e) { }
			try { stmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
