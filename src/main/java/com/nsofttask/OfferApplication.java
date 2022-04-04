package com.nsofttask;

import com.nsofttask.service.DataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfferApplication.class, args);
	}

	@Bean
	CommandLineRunner run(DataService dataService) {
		return args -> {
			dataService.init();
		};
	}
}
