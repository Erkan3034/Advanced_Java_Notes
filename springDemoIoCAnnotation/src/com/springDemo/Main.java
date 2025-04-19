package com.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		/*
		 * IoC: IOC (Inversion of Control), yazılımda bir sınıfın bağımlılıklarını dışarıdan alarak, +
		 * kontrolün sınıftan başka bir yapı (genellikle bir framework) tarafından yönetilmesini sağlayan 
		 * bir tasarım prensibidir.
		 * 
		 * (Birbirinin alternatifi olan işleri farklı classlarda yazmak.)
		 * */
		
		//DEPENDENCY INJECTION
		
		/*
		 * ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * 
		 * ICustomerDal customerDal = context.getBean("database",ICustomerDal.class);
		 * //ICustomerDal ile ilgili database'de ne varsa bana onu döndür.
		 * customerDal.add();
		 */
		
		//=====================================================CLASS CONFIG====================
		
		/*
		 * //Anotasyon Config ile işlem: 
		 * AnnotationConfigApplicationContext context =
		 * new AnnotationConfigApplicationContext(IocConfig.class);
		 * 
		 * //IocConfig dosyasına database için gidip hangi dosyada database anotasyonu
		 * varsa onu çağıracak.
		 * 
		 * ICustomerDal customerDal = context.getBean("database",ICustomerDal.class);
		 * 
		 * //ICustomerDal ile ilgili database'de ne varsa bana onu döndür.
		 * customerDal.add();
		 */
		
		
		//Anotasyon Config ile işlem:
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
		
		//IocConfig dosyasına database için gidip hangi dosyada database anotasyonu varsa onu çağıracak.
		
		ICustomerService customerService = context.getBean("service",ICustomerService.class); 
		customerService.add();
		customerService.delete();
		
		context.close();
		
		
		/*
		CustomerManager customerManager = new CustomerManager(context.getBean("database",ICustomerDal.class));
		//CustomerManager customerManager = new CustomerManager( new MySqlCustomerDal() );
		customerManager.add();
		System.out.println("...");
		customerManager.delete();
		
		*/
		
		
		System.out.println("");
		//CustomerManager customerManager2 = new CustomerManager( new OracleCustomerDal() );
		//customerManager2.add();
	}

}
