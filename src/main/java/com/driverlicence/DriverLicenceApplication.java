package com.driverlicence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DriverLicenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverLicenceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {

		};
	}
}
