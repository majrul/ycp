package com.cdac.test;

import com.cdac.dao.ProductDao;
import com.cdac.entity.Product;

public class ProductTest {

	public static void main(String[] args) {
		Product p = new Product();
		p.setName("Nokia 6600");
		p.setPrice(4500);
		p.setQuantity(99);
		
		ProductDao dao = new ProductDao();
		dao.add(p);
	}
}
