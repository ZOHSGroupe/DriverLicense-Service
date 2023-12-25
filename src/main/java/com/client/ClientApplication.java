package com.client;

import com.client.entity.Client;
import com.client.entity.Vihecule;
import com.client.repositor.ClientRepository;
import com.client.repositor.ViheculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {

		};
	}
}
