package com.javaCourse.project.hibernateAndJPA.Bussiness;

import java.util.List;

import com.javaCourse.project.hibernateAndJPA.Entities.City;


/*
 * Bussines katmaında açtıımız bu interface'i iş kodlaırmızda kullanmak üzere açıyoruz(örneğin test edereken bize true-false lazım iken).
 * Genel kullanım için ise yine DataAccess katmanındaki interface'i kullanırız.
 * 
 * */

public interface ICityService {


	List<City> getAll(); //get all cities
	
	void add(City city); // add city
	
	void update(City city); //Update city
	
	void delete(City city); //delee City
	
	City getById(int id);
}
