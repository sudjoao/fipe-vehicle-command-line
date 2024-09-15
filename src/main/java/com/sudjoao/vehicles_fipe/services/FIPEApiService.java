package com.sudjoao.vehicles_fipe.services;

import com.sudjoao.vehicles_fipe.enums.FIPEVehiclesCategories;
import com.sudjoao.vehicles_fipe.models.VehicleBrandsDTO;
import com.sudjoao.vehicles_fipe.models.VehicleDTO;
import com.sudjoao.vehicles_fipe.models.VehicleFullInfoDTO;

import java.util.List;

public class FIPEApiService extends ApiService {
    private final static String apiUrl = "https://parallelum.com.br/fipe/api/v1";

    public List<VehicleDTO> getByVehicleType(FIPEVehiclesCategories vehicle) {
        String url = "%s/%s/marcas".formatted(apiUrl, vehicle.getEndpoint());
        var response = get(url);

        return MapperService.toObjectList(response.body(), VehicleDTO.class);
    }

    public VehicleBrandsDTO getByBrand(FIPEVehiclesCategories vehicle, int brandOption) {
        String url = "%s/%s/marcas/%d/modelos".formatted(apiUrl, vehicle.getEndpoint(), brandOption);
        var response = get(url);

        return MapperService.toObject(response.body(), VehicleBrandsDTO.class);
    }

    public List<VehicleDTO> getYearsByModel(FIPEVehiclesCategories vehicle, int brandOption, int modelOption) {
        String url = "%s/%s/marcas/%d/modelos/%d/anos".formatted(apiUrl, vehicle.getEndpoint(), brandOption, modelOption);
        var response = get(url);

        return MapperService.toObjectList(response.body(), VehicleDTO.class);
    }

    public VehicleFullInfoDTO getVehicleFullInformation(FIPEVehiclesCategories vehicle, int brandOption, int modelOption, String year) {
        String url = "%s/%s/marcas/%d/modelos/%d/anos/%s".formatted(apiUrl, vehicle.getEndpoint(), brandOption, modelOption, year);
        var response = get(url);

        return MapperService.toObject(response.body(), VehicleFullInfoDTO.class);
    }
}
