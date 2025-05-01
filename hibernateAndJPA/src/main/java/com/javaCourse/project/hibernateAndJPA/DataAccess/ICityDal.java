package com.javaCourse.project.hibernateAndJPA.DataAccess;
import com.javaCourse.project.hibernateAndJPA.Entities.City;

import java.util.List;


public interface ICityDal {

	List<City> getAll(); //get all cities
	
	void add(City city); // add city
	
	void update(City city); //Update city
	
	void delete(City city); //delee City
	
	City getById(int id); 
}
