package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class AngularBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularBackendApiApplication.class, args);
		System.out.println("Application has started successfully......");
	}

}
