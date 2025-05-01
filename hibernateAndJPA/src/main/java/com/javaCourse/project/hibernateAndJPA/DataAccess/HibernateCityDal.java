package com.javaCourse.project.hibernateAndJPA.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import com.javaCourse.project.hibernateAndJPA.Entities.City;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * HibernateCityDal, City entity'si için Hibernate üzerinden
 * veritabanı işlemlerini (CRUD) gerçekleştiren sınıftır.
 * Bu sınıf DAO (Data Access Object) katmanında yer alır.
 */

@Repository // Spring’e bu sınıfın bir repository (veri erişim bileşeni) olduğunu belirtir
public class HibernateCityDal implements ICityDal {

    private EntityManager entityManager;

    /**
     * EntityManager, JPA ile veritabanı işlemlerini yapmamızı sağlayan ana bileşendir.
     * Spring, @Autowired ile bunu otomatik olarak inject ede
     */
    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Tüm şehir kayıtlarını getirir.
     * @return List<City> şehir listesi
     */
    
    @Override
    @Transactional // Veritabanı işlemi olduğu için transaction kapsamında yapılmalı
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class); // EntityManager üzerinden Hibernate Session alınır
        return session.createQuery("from City", City.class).getResultList(); // HQL ile tüm City nesneleri çekilir
    }

    /**
     * Yeni şehir ekler.
     * @param city eklenecek şehir
     */
    @Override
    @Transactional 
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(city); // persist → yeni nesne veritabanına ekler
    }

    
    
    
    /**
     * Var olan şehir kaydını günceller.
     * @param city güncellenecek şehir nesnesi
     */
    @Override
    @Transactional
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(city); // merge → var olan veriyi günceller
    }

    
    
    /**
     * Belirtilen şehir kaydını veritabanından siler.
     * @param city silinecek şehir nesnesi
     */
    @Override
    @Transactional
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        // Silmeden önce veritabanından id ile tam nesne alınır
        City cityToDelete = session.get(City.class, city.getId());
        session.remove(cityToDelete); // remove → nesneyi siler
    }
}


/*
 * @Repository → Bu anotasyon, Spring’e bu sınıfın bir DAO olduğunu belirtir. Böylece exception handling gibi bazı işlemleri otomatik yönetebilir.

 * @Transactional → Her metotta işlemin tek parça (atomik) yapılmasını sağlar. Örneğin işlem yarıda kalırsa rollback yapar.

*  unwrap(Session.class) → Hibernate'e özel işlemler yapmak için kullanılır. EntityManager JPA'nın genel standardı olsa da, Hibernate özelliklerini kullanmak için unwrap gerekir.
 * */
