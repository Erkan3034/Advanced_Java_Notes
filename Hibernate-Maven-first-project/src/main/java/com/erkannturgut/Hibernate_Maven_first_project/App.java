package com.erkannturgut.Hibernate_Maven_first_project;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Hibernate yapılandırmasını yükle
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(User.class)
                                    .buildSessionFactory();

        // Session aç
        Session session = factory.getCurrentSession();

        try {
            //===========================> INSERT==========
//            User user = new User();
//            user.setName("Erkan");
//            user.setSurname("TURGUTT");
//            user.setAge(22);
//            user.setdOB(new Date(2024));
            

        	
        	// Örneğin id'si 1 olan kullanıcıyı çekiyoruz
        	User bulunanUser = session.get(User.class, 0);

        	System.out.println("Bulunan User: " + bulunanUser.getName());

;

            
            
            
            // Veritabanı işlemleri başlasın
            session.beginTransaction();
           // session.save(user);
            session.save(bulunanUser);
            session.getTransaction().commit();

            System.out.println("Kullanıcı başarıyla kaydedildi!");

        } finally {
            factory.close();
        }
    }
}
