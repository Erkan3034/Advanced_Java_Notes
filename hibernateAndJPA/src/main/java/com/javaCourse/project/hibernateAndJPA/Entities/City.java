package com.javaCourse.project.hibernateAndJPA.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {


	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //otomatik Id arttırma
	
	private int Id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Countrycode")
	private String countryCode;
	
	@Column(name = "District")
	private String district;
	
	@Column(name = "Population")
	private int population;
	
	
	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.Id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	
	public City() {}
	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public int getPopulation() {
		return population;
	}


	public void setPopulation(int population) {
		this.population = population;
	}



}