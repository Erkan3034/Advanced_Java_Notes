package com.javaCourse.project.hibernateAndJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.javaCourse.project.hibernateAndJPA.DataAccess")
@EntityScan(basePackages = "com.javaCourse.project.hibernateAndJPA.Entities")
public class HibernateAndJPAApplication {

    // Eksik olan main metodu
    public static void main(String[] args) {
        SpringApplication.run(HibernateAndJPAApplication.class, args);
    }
}