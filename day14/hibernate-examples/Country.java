package com.cdac.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

	@Id
	private String name;
	
	private int population;
	private String language;
	
	@OneToMany(mappedBy = "country")
	private Set<State> states;
	
}
