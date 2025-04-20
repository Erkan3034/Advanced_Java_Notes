package com.hibernateDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();

		// Unit of work
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// select * from city;

			// ==================== Select islemi=================

			// where kosulu ile TUR , Ankara olanları aldık.
			// List<City> cities = session.createQuery("from City c where c.countryCode =
			// 'TUR' AND c.district ='Ankara' ").getResultList();

			// ==================== Arama (LIKE) islemi=================

			// Sehir ismi icinde "kar" tümccesinin geçtiği sehir isimlerini alır.
			// List<City> cities = session.createQuery("from City c where c.name LIKE
			// '%kar%'").getResultList();

			// ==================== ORDER BY islemi=================

			// Sehirleri seç ve isme göre sırala (ASC - Ascending) - (DESC -descending) =>
			// Artan- Azalan
			// List<City> cities = session.createQuery("from City c ORDER BY c.name
			// ASC").getResultList();

			// ==================== GROUP BY islemi=================

			// CounryCode'a göre grupla(grupları verir)

			/*
			 * List<String> countryCodes =
			 * session.createQuery("select c.countryCode from City c GROUP BY c.countryCode"
			 * ).getResultList();
			 * 
			 * 
			 * 
			 * for (String countryCode : countryCodes) { System.out.println(countryCode); }
			 */

			// ====================== INSERT ISLEMI  ==========================================

//			City insertedCity = new City();
//			insertedCity.setCountryCode("TUR");
//			insertedCity.setDistrict("Marmara");
//			insertedCity.setName("Istanbul 30");
//			insertedCity.setPopulation(16000000);
//			insertedCity.setId(303434);

			
			
			
			// ====================== UPDATE ISLEMI ==========================================

//			City updatedCity = session.get(City.class, 840); // 840. ID'deki sehir
//			updatedCity.setPopulation(500000);
//			updatedCity.setName("ERKAN'S CITY");

			
			
			// ====================== DELETE ISLEMI ==========================================

			City deletedCity = session.get(City.class, 5); //5 id'li sehiri sil.
			session.delete(deletedCity);
			
			
			
			// <<<<<<<<<<<<<<---insert--->>>>>>>>>>>
			// session.save(insertedCity);
			// System.out.println("Sehir eklendi!");

			// <<<<<<<<<<<<<<---update--->>>>>>>>>>>
			//session.save(updatedCity);
			//System.out.println("Sehir Güncellendi(Nüfus): " + updatedCity.getPopulation() + " - " + updatedCity.getName());

			
			// <<<<<<<<<<<<<<---delete--->>>>>>>>>>>
			System.out.println("Sehir silindi: " + deletedCity.getName());

			session.getTransaction().commit();
		} finally {

			factory.close();
		}
	}

}
