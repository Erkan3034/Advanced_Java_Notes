package com.springDemo;

import org.springframework.beans.factory.annotation.Value;

public class MySqlCustomerDal implements ICustomerDal {
	
	//String Injection
	@Value("${database.mysql.url}")
	String connectionString;
	
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	
	//Db kodları yer alır.
	public void add() {
		System.out.println("Connection String: " +this.connectionString);
		System.out.println("MySql veritabanına eklendi");
	}

	@Override
	public void delete() {
		
		
	}
}
