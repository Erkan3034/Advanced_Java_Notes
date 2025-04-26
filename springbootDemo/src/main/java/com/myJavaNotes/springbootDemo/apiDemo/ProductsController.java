package com.myJavaNotes.springbootDemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductsController {

	@GetMapping("/")
	public String get() 
	{
		return "Hi Erkan, this is your first SpringBoot project";
	}
	
	@GetMapping("/products")
	public String getProducts() 
	{
		return "Laptop and Phones";
	}
	
	@GetMapping("/products/phones")
	public String getPhones() 
	{
		return "Samsung Galaxy A55";
	}
	
}
