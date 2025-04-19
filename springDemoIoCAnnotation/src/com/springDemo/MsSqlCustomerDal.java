package com.springDemo;

import org.springframework.beans.factory.annotation.Value;

//import org.springframework.stereotype.Component;

//@Component("database") //tanımı buda yapmak yerine daha sağam bir yapı kurak için IocCOnfig içinde tanımlama(bean ile ) yapalım.

public class MsSqlCustomerDal  implements ICustomerDal{
	
	//String Injection
	
	@Value("${database.mssql.url}")
	String connectionString;
	
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	

	@Override
	public void add() {
		System.out.println("Connection String: " +this.connectionString);
		System.out.println("MsSql veritabanına eklendi...");
	}

	@Override
	public void delete() {
		System.out.println("MsSql veritabanından silindi...");
		
	}
	

}
