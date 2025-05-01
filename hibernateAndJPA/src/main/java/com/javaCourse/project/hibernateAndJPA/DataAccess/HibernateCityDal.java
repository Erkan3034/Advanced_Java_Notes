package com.javaCourse.project.hibernateAndJPA.DataAccess;

import java.util.List;

import com.javaCourse.project.hibernateAndJPA.Entities.City;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;



import javax.persistence.EntityManager;


//JPA - (	ORM işlemleri için Java'da standart )
public class HibernateCityDal implements ICityDal {
	
	private EntityManager entityManager; 
	
	
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	// AOP - Aspect Oriented Programming
	@Override
	@Transactional
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		
		List<City> cities = session.createQuery("from City" , City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {

		
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(City city) {
		// TODO Auto-generated method stub

	}

}

/*
 * 💠 JPA (Java Persistence API) Nedir? 🔹 
 * Tanım: JPA, Java dünyasında ORM yapmanın resmi standardıdır. Yani bir arayüzdür (interface), bir framework değildir.
 * 
 * JPA bir standarttır, Hibernate gibi kütüphaneler bu standardı uygular.
 * 
 * 🔹 Ne Sağlar? Anotasyonlarla tablo eşlemesi (@Entity, @Column, @Id vs)
 * 
 * Veritabanı işlemleri için standart methodlar (persist, merge, remove) Transaction yönetimi
 * 
 * JPQL (Java Persistence Query Language)
 */
