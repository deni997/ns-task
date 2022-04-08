package com.nsofttask;

import com.google.gson.Gson;
import com.nsofttask.enumerations.Status;
import com.nsofttask.model.Market;
import com.nsofttask.model.MarketOutcome;
import com.nsofttask.service.DataService;
import com.nsofttask.util.FileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
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
