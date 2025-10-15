package com.insurance.premium_static_data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PremiumStaticDataApplication {

	private static final Logger log = LoggerFactory.getLogger(PremiumStaticDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PremiumStaticDataApplication.class, args);
		log.info("PremiumStaticDataApplication started successfully.");
	}

}
