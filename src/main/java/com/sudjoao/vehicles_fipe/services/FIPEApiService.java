package com.sudjoao.vehicles_fipe.services;

import com.sudjoao.vehicles_fipe.enums.FIPEVehiclesCategories;
import com.sudjoao.vehicles_fipe.models.Vehicle;

import java.util.List;

public class FIPEApiService extends ApiService {
    private final static String apiUrl = "https://parallelum.com.br/fipe/api/v1";

    public List<Vehicle> getByVehicleType(int option) {
        String type = vehicleEndpoint(option);
        String url = "%s/%s/marcas".formatted(apiUrl, type);
        var response = get(url);

        return MapperService.toObjectList(response.body(), Vehicle.class);
    }


    public <T extends Vehicle> String vehicleEndpoint(int option) {
        return FIPEVehiclesCategories.getDescriptionByOption(option);
    }

}
