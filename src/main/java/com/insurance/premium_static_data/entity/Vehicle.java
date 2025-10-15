package com.insurance.premium_static_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class representing a vehicle in the insurance system.
 * This JPA entity maps to the "vehicle" table in the database and contains
 * static vehicle information used for insurance premium calculations.
 * 
 * The entity stores basic vehicle information including vehicle types
 * that are used to categorize vehicles for insurance purposes.
 * 
 * @author Aylin Yilmaz
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {
    
    /**
     * Unique identifier for the vehicle record.
     * This field is auto-generated using database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Type or category of the vehicle.
     * This field stores the vehicle classification used for insurance
     * premium calculations and categorization purposes.
     * Maps to the "vehicle_type" column in the database.
     */
    @Column(name = "vehicle_type")
    private String vehicleType;

    /**
     * Retrieves the unique identifier of the vehicle.
     * 
     * @return the unique ID of the vehicle record
     */
    public Long getId() {
        return id;
    }

    /**
     * Retrieves the type or category of the vehicle.
     * 
     * @return the vehicle type as a string (e.g., "SUV")
     */
    public String getVehicleType() {
        return vehicleType;
    }

}
