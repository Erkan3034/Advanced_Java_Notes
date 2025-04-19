package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		/*
		 * IoC: IOC (Inversion of Control), yazılımda bir sınıfın bağımlılıklarını dışarıdan alarak, 
		 * kontrolün sınıftan başka bir yapı (genellikle bir framework) tarafından yönetilmesini sağlayan 
		 * bir tasarım prensibidir.
		 * 
		 * (Birbirinin alternatifi olan işleri farklı classlarda yazmak.)
		 * */
		
		//DEPENDENCY INJECTION
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICustomerService customerService = context.getBean("service",ICustomerService.class);
		customerService.add();
		
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
