package com.javaCourse.project.hibernateAndJPA.DataAccess;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

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
@Repository // Spring'e bu sınıfın bir repository (veri erişim bileşeni) olduğunu belirtir
public class HibernateCityDal implements ICityDal {

    private final EntityManager entityManager;

    /**
     * EntityManager, JPA ile veritabanı işlemlerini yapmamızı sağlayan ana bileşendir.
     * Spring, @Autowired ile bunu otomatik olarak inject eder
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

    
    
    @Override
    @Transactional
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id); // Burada sadece id kullanılmalı
        if (city == null) {
            throw new EntityNotFoundException("Şehir bulunamadı: id = " + id);
        }
        return city;
    }

}