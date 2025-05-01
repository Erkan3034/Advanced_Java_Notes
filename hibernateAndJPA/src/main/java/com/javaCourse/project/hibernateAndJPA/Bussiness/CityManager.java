package com.javaCourse.project.hibernateAndJPA.Bussiness;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaCourse.project.hibernateAndJPA.DataAccess.ICityDal;
import com.javaCourse.project.hibernateAndJPA.Entities.City;

/**
 * İş katmanı (Business Layer)
 * Şehirlerle ilgili iş kurallarının yazıldığı sınıftır.
 * DataAccess ile Controller arasında köprü olur.
 */
@Service // Bu sınıfın Spring tarafından bir servis (business class) olarak yönetileceğini belirtir
public class CityManager implements ICityService {

    private ICityDal cityDal;

    /**
     * Constructor Injection ile ICityDal nesnesi enjekte edilir.
     * Bu sayede CityManager sadece Hibernate'e değil, farklı implemantasyonlara da uyumlu olur (esneklik sağlar).
     */
    @Autowired
    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }

    
    
    /**
     * Tüm şehirleri döndürür.
     * @return List<City>
     */
    @Override
    @Transactional
    public List<City> getAll() {
        return cityDal.getAll();
    }

    
    
    /**
     * Yeni şehir ekler.
     * @param city eklenecek şehir nesnesi
     */
    @Override
    @Transactional
    public void add(City city) {
        // Business Rules
        if (city.getName() == null || city.getName().trim().isEmpty()) {
            throw new RuntimeException("Şehir ismi boş olamaz!");
        }

        if (city.getName().length() > 100) {
            throw new RuntimeException("Şehir ismi çok uzun!");
        }

        // Tüm kurallardan geçtiyse veritabanına ekle
        this.cityDal.add(city);
    }

    
    /**
     * Var olan şehir bilgisini günceller.
     * @param city güncellenecek şehir
     */
    @Override
    @Transactional
    public void update(City city) {
        // Business Rules
        this.cityDal.update(city);
    }

    
    
    /**
     * Şehir kaydını siler.
     * @param city silinecek şehir
     */
    @Override
    @Transactional
    public void delete(City city) {
        // Business Rules
        this.cityDal.delete(city);
    }



	@Override
	public City getById(int id) {

		return this.cityDal.getById(id);
	}
}
