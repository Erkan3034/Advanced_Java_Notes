package com.erkannturgut.Hibernate_Maven_first_project;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "personeller")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    @Column(name = "isim")
    private String name;
    
    @Column(name = "soyad")
    private String surname;
    
    @Column(name = "yas")
	private int age;
    
    @Column(name = "dogumTarihi")
    private Date dOB;
    

    // Getter ve Setter'lar
    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
    public Long getId() { return id; }
    public void setId(int id) { this.id = (long) id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    
    
}
