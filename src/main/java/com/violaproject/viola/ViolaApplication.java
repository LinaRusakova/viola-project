package com.violaproject.viola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ViolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViolaApplication.class, args);
	}

}
