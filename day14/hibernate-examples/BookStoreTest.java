package com.cdac.test;

import org.junit.Test;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Book;
import com.cdac.entity.BookDetails;

public class BookStoreTest {

	@Test
	public void store() {
		Book b = new Book();
		b.setName("Java Complete Reference");
		b.setAuthor("Herbert Schildt");
		
		BookDetails bd = new BookDetails();
		bd.setPublication("TMGH");
		bd.setCost(500);
		bd.setYear(2018);
		
		//b.setBookDetails(bd);
		bd.setBook(b);
		
		GenericDao dao = new GenericDao();
		dao.add(b); //if we have enabled cascade, no need to save the bookdetails separately
		//dao.add(bd);
	}
}
