package com.cdac.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class State {

	@Id
	private String name;
	
	private int population;
	private String language;
	
	@ManyToOne
	@JoinColumn(name = "country_name")
	private Country country;
}
