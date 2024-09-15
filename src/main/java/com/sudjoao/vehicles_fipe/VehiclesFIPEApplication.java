package com.sudjoao.vehicles_fipe;

import com.sudjoao.vehicles_fipe.enums.FIPEVehiclesCategories;
import com.sudjoao.vehicles_fipe.models.VehicleDTO;
import com.sudjoao.vehicles_fipe.services.FIPEApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class VehiclesFIPEApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VehiclesFIPEApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FIPEApiService fipeApiService = new FIPEApiService();
        System.out.println("Which type of vehicle do you want to consult?");
        FIPEVehiclesCategories.getAllOptions().forEach(System.out::println);
        var vehicleOption = FIPEVehiclesCategories.getByOption((scanner.nextInt()));
        scanner.nextLine();
        fipeApiService.getByVehicleType(vehicleOption).forEach(System.out::println);
        System.out.println("Type the code that you want to verify the models:");
        var vehicleBrand = scanner.nextInt();
        fipeApiService.getByBrand(vehicleOption, vehicleBrand).modelos().forEach(System.out::println);
        System.out.println("Type the code that you want to verify the prices");
        var vehicleModel = scanner.nextInt();
        var vehicleYears = fipeApiService.getYearsByModel(vehicleOption, vehicleBrand, vehicleModel);
        var vehicles = vehicleYears.stream().map(v -> fipeApiService.getVehicleFullInformation(vehicleOption, vehicleBrand, vehicleModel, v.codigo())).collect(Collectors.toList());
        vehicles.forEach(System.out::println);
    }
}
