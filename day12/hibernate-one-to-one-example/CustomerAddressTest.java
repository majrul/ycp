package com.cdac.test;

import org.junit.Test;

import com.cdac.dao.CustomerAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Customer;

public class CustomerAddressTest {

	@Test
	public void addCustomer() {
		Customer c = new Customer();
		c.setName("John");
		c.setEmail("john@gmail.com");
		
		CustomerAddressDao dao = new CustomerAddressDao();
		dao.addCustomer(c);
		
	}

	@Test
	public void addAddress() {
		CustomerAddressDao dao = new CustomerAddressDao();
		
		Customer c = dao.fetchCustomer(1);
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setState("MH");
		addr.setPincode(400001);
		addr.setCustomer(c);
		
		dao.addAddress(addr);
		
	}
}
