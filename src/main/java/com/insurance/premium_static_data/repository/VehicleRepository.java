package com.insurance.premium_static_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.insurance.premium_static_data.entity.Vehicle;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    @Query("SELECT v.vehicleType FROM Vehicle v")
    List<String> findAllVehicleTypes();
    
}
