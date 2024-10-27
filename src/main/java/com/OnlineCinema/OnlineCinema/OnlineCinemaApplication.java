package com.OnlineCinema.OnlineCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class OnlineCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCinemaApplication.class, args);
	}

}
