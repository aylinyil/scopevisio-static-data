package com.insurance.premium_static_data.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.premium_static_data.repository.VehicleRepository;

/**
 * REST Controller for vehicle-related operations.
 * Provides endpoints for retrieving vehicle static data used in insurance premium calculations.
 * 
 * This controller handles HTTP requests related to vehicle information,
 * primarily serving vehicle types that are used by frontend applications
 * to populate dropdown lists and form selections.
 * 
 * @author Aylin Yilmaz
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vehicle")
public class VehicleController {

    /**
     * Logger instance for this controller.
     */
    private static final Logger log = LoggerFactory.getLogger(VehicleController.class);
    
    /**
     * Repository for vehicle data access operations.
     */
    private final VehicleRepository vehicleRepository;

    /**
     * Constructor for VehicleController.
     * Initializes the controller with the required vehicle repository dependency.
     * 
     * @param vehicleRepository the repository used for vehicle data access operations
     */
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Retrieves all available vehicle types from the database.
     * Returns the vehicle types formatted as HTML option elements
     * for direct use in frontend dropdown components.
     * 
     * The response contains HTML option tags with vehicle type values
     * that can be directly embedded into select elements.
     * 
     * @return a string containing HTML option elements with all available vehicle types
     * @apiNote This endpoint is designed for frontend integration and returns HTML 
     *
     */
    @GetMapping("/types")
    public String getAllVehicleTypes() {

        log.info("GET /vehicle/types received.");

        List<String> vehicleTypes = vehicleRepository.findAllVehicleTypes();

        log.debug("Retrieved vehicle types: {}", vehicleTypes);

        StringBuilder html = new StringBuilder();
        for (String vehicleType : vehicleTypes) {
            html.append(String.format("<option value=\"%s\">%s</option>", vehicleType, vehicleType));
        }

        return html.toString();

    }
}
