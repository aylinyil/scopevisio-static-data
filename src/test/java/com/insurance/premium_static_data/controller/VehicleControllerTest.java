package com.insurance.premium_static_data.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.insurance.premium_static_data.repository.VehicleRepository;

@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleController vehicleController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
    }

    @Test
    void calculate_ok() throws Exception {
        List<String> vehicleTypes = Arrays.asList("SUV", "Sedan");
        when(vehicleRepository.findAllVehicleTypes()).thenReturn(vehicleTypes);

        mockMvc.perform(get("/vehicle/types"))
                .andExpect(status().isOk())
                .andExpect(content().string("<option value=\"SUV\">SUV</option><option value=\"Sedan\">Sedan</option>"));
    }

    @Test
    void calculate_empty() throws Exception {
        when(vehicleRepository.findAllVehicleTypes()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/vehicle/types"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void calculate_single() throws Exception {
        List<String> vehicleTypes = Collections.singletonList("Truck");
        when(vehicleRepository.findAllVehicleTypes()).thenReturn(vehicleTypes);

        mockMvc.perform(get("/vehicle/types"))
                .andExpect(status().isOk())
                .andExpect(content().string("<option value=\"Truck\">Truck</option>"));
    }
}
