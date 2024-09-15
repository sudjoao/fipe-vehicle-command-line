package com.sudjoao.vehicles_fipe;

import com.sudjoao.vehicles_fipe.enums.FIPEVehiclesCategories;
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
        System.out.println(fipeApiService.getByVehicleType(FIPEVehiclesCategories.CAR));
        System.out.println(fipeApiService.getByBrand(FIPEVehiclesCategories.CAR, 1));
        System.out.println(fipeApiService.getYearsByModel(FIPEVehiclesCategories.CAR, 1, 1));
        System.out.println(fipeApiService.getVehicleFullInformation(FIPEVehiclesCategories.CAR, 1, 1, "1992-1"));
    }
}
