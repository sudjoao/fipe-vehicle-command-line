package com.sudjoao.vehicles_fipe.services;

import com.sudjoao.vehicles_fipe.models.CarDTO;
import com.sudjoao.vehicles_fipe.models.MotorcycleDTO;
import com.sudjoao.vehicles_fipe.models.Vehicle;

import java.util.List;
import java.util.Map;

public class FIPEApiService extends ApiService {
    private final static String apiUrl = "https://parallelum.com.br/fipe/api/v1";

    public <T extends Vehicle> List<Vehicle> getByBrand(Class<T> vehicleClass) {
        String type = vehicleEndpoint(vehicleClass);
        String url = "%s/%s/marcas".formatted(apiUrl, type);
        var response = get(url);
        System.out.println(response.body());
        return null;
    }

    public <T extends Vehicle> String vehicleEndpoint(Class<T> vehicleClass) {
        if (vehicleClass.equals(CarDTO.class)) {
            return "carros";
        } else if (vehicleClass.equals(MotorcycleDTO.class)) {
            return "motos";
        }
        return null;
    }

}
