package com.insurance.premium_static_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.insurance.premium_static_data.entity.Vehicle;
import java.util.List;

/**
 * Repository interface for Vehicle entity data access operations.
 * Extends JpaRepository to provide standard CRUD operations and custom query methods
 * for retrieving vehicle-related static data from the database.
 * 
 * This repository serves as the data access layer for vehicle information
 * used in insurance premium calculations and vehicle categorization.
 * 
 * @author Aylin Yilmaz
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    /**
     * Retrieves all distinct vehicle types from the vehicle table.
     * This method executes a custom JPQL query to fetch only the vehicle type
     * values without retrieving the complete Vehicle entity objects.
     * 
     * The returned list contains unique vehicle type strings that can be
     * used for populating dropdown lists, validation, or categorization purposes.
     * 
     * @return a list of all distinct vehicle types available in the database
     */
    @Query("SELECT v.vehicleType FROM Vehicle v")
    List<String> findAllVehicleTypes();
    
}
