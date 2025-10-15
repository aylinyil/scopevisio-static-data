package com.insurance.premium_static_data.model;

/**
 * Data Transfer Object (DTO) representing a request for vehicle information.
 * This class encapsulates the request parameters sent to the vehicle-related endpoints
 * in the Premium Static Data API.
 * 
 * The Request model is used to capture and validate incoming HTTP request data
 * before processing vehicle-related operations.
 * 
 * @author Aylin Yilmaz
 */
public class Request {
    
    /**
     * The type of vehicle being requested or queried.
     * This field contains the vehicle category or classification
     * that the client is interested in retrieving information about.
     */
    private String vehicleType;

    /**
     * Retrieves the vehicle type from the request.
     * 
     * @return the vehicle type specified in the request, or null if not set
     */
    public String getVehicleType() {
        return vehicleType;
    }
}
