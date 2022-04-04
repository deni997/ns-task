package com.nsofttask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NsoftTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NsoftTaskApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			ReadJSONFromFile readJson = new ReadJSONFromFile();
			readJson.readJson();
		};
	}
}
