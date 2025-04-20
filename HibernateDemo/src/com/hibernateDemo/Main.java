package com.hibernateDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		

		Session session = factory.getCurrentSession();
		
		
		
		try {
			
			session.beginTransaction();
			
			//select * from city;
			
			//==================== Select islemi=================
			
			// where kosulu ile TUR , Ankara olanları aldık.
			  //List<City> cities = session.createQuery("from City c where c.countryCode = 'TUR' AND c.district ='Ankara' ").getResultList(); 
			
			
			
			//==================== Arama (LIKE) islemi=================
			
			//Sehir ismi icinde "kar" tümccesinin geçtiği sehir isimlerini alır.
			  //List<City> cities = session.createQuery("from City c where c.name  LIKE '%kar%'").getResultList(); 
			
			
			
			//==================== ORDER BY islemi=================
			
			//Sehirleri seç ve isme göre sırala (ASC - Ascending) - (DESC -descending) => Artan- Azalan
			  //List<City> cities = session.createQuery("from City c ORDER BY c.name ASC").getResultList(); 
			
			
			//==================== GROUP BY islemi=================
			
			//CounryCode'a göre grupla(grupları verir)
			
			/*
			 * List<String> countryCodes =
			 * session.createQuery("select c.countryCode from City c GROUP BY c.countryCode"
			 * ).getResultList();
			 * 
			 * 
			 * 
			 * for (String countryCode : countryCodes) { System.out.println(countryCode); }
			 */
			
			//====================== INSERT ISLEMI ==========================================
			
			City city = new City();			
			city.setCountryCode("TUR");
			city.setDistrict("Marmara");
			city.setName("Istanbul 30");
			city.setPopulation(16000000);
			city.setId(303434);

			
			
			
			
			
			
			
			
			
			
			
			
			
			session.save(city);
			session.getTransaction().commit();
			System.out.println("Sehir eklendi!");
		} finally {
			
			factory.close();
		} 
	}

}
