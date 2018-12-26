package com.cdac.entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class BookDetails {

	private int id;
	
	private String publication;
	private double cost;
	private int year;
	
	@OneToOne
	@JoinColumn(name = "book_id")
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
