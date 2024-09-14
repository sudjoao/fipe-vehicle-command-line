package com.sudjoao.vehicles_fipe;

import com.sudjoao.vehicles_fipe.models.CarDTO;
import com.sudjoao.vehicles_fipe.models.MotorcycleDTO;
import com.sudjoao.vehicles_fipe.models.Vehicle;
import com.sudjoao.vehicles_fipe.services.ApiService;
import com.sudjoao.vehicles_fipe.services.FIPEApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesFIPEApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesFIPEApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FIPEApiService fipeApiService = new FIPEApiService();
        fipeApiService.getByBrand(CarDTO.class);
        fipeApiService.getByBrand(MotorcycleDTO.class);
    }
}
