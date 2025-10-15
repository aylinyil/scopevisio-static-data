package com.insurance.premium_static_data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Premium Static Data microservice.
 * This Spring Boot application provides REST APIs for retrieving vehicle-related
 * static data used in insurance premium calculations.
 * 
 * The application serves as a data provider for vehicle types and other
 * insurance-related static information.
 * 
 * @author Aylin Yilmaz
 */
@SpringBootApplication
public class PremiumStaticDataApplication {

	/**
	 * Logger instance for this class.
	 */
	private static final Logger log = LoggerFactory.getLogger(PremiumStaticDataApplication.class);

	/**
	 * Main entry point for the Spring Boot application.
	 * Initializes and starts the Premium Static Data application context.
	 * 
	 * @param args command line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(PremiumStaticDataApplication.class, args);
		log.info("PremiumStaticDataApplication started successfully.");
	}

}
