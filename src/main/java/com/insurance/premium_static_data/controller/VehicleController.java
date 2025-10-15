package com.insurance.premium_static_data.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.premium_static_data.repository.VehicleRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vehicle")
public class VehicleController {

    private static final Logger log = LoggerFactory.getLogger(VehicleController.class);
    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

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
