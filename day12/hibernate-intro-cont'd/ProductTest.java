package com.cdac.test;

import java.util.List;

import org.junit.Test;

import com.cdac.dao.ProductDao;
import com.cdac.entity.Product;

public class ProductTest {

	@Test
	public void addProduct() {
		Product p = new Product();
		p.setName("Nokia 6810");
		p.setPrice(4500);
		p.setQuantity(99);
		
		ProductDao dao = new ProductDao();
		dao.add(p);
	}
	
	@Test
	public void fetchProduct() {
		ProductDao dao = new ProductDao();
		Product p = dao.fetch(20);
		System.out.println(p); //override toString()
		System.out.println(p.getId()); 
		System.out.println(p.getName());
		System.out.println(p.getPrice());
		System.out.println(p.getQuantity());
	}
	
	@Test
	public void fetchAll() {
		ProductDao dao = new ProductDao();
		List<Product> products = dao.fetchAll();
		for(Product product : products)
			System.out.println(product);
	}
	
	@Test
	public void updateProduct() {
		ProductDao dao = new ProductDao();
		Product p = dao.fetch(20);
		
		p.setPrice(6500);
		dao.update(p);
	}
	
	@Test
	public void deleteProduct() {
		ProductDao dao = new ProductDao();
		dao.remove(20);
	}
}
