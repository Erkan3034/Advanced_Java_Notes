package com.springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.PropertySource;

@Configuration

@ComponentScan("com.springDemo")
@PropertySource("classpath:values.properties") //connection strginlleri yönetmek için.


class IocConfig {
	
	@Bean
	public ICustomerDal database() {
		return new MsSqlCustomerDal();
		
	}
	
	@Bean
	public ICustomerService service() { 
		return new CustomerManager(database());
		
	}

	

}
