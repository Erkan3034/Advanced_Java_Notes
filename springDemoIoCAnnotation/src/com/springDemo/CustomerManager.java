package com.springDemo;

public class CustomerManager implements ICustomerService {
	//Müşteri kontrolü. Eğer tüm şartlar sağlanıyorsa customerDal çağrılır.
	private ICustomerDal customerDal; //çağır
	
	

	//Constructor injection
	
	public CustomerManager(ICustomerDal customerDal) { //gelen customerDal türü
		this.customerDal = customerDal;
	}
	
	
	
	
	/*
	 * //Setter Injection public void setCustomerDal(ICustomerDal customerDal) {
	 * this.customerDal = customerDal; }
	 */

	public void add() { //ICustomerDal prop.
		//iş kuralları
		customerDal.add();
	}
	
	public void delete() { //ICustomerDal prop.
		customerDal.delete();
	}
	//Bir class başka bir classı kullandığında NEWLEMEMELİDİR!!!

}
