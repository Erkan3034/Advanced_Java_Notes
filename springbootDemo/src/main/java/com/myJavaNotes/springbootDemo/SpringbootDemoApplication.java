package com.myJavaNotes.springbootDemo;

//netstat -ano | findstr :8080  ---> taskkill /PID 87680 /F (port kill for start)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
