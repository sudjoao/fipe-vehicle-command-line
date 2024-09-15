package com.sudjoao.vehicles_fipe.enums;

import com.sudjoao.vehicles_fipe.models.CarDTO;
import com.sudjoao.vehicles_fipe.models.MotorcycleDTO;
import com.sudjoao.vehicles_fipe.models.TruckDTO;

public enum FIPEVehiclesCategories {
    CAR(CarDTO.class, "carros"),
    MOTORCYCLE(MotorcycleDTO.class, "motos"),
    TRUCK(TruckDTO.class, "caminhoes");

    private final Class<?> vehicleClass;
    private final String endpoint;

    FIPEVehiclesCategories(Class<?> vehicleClass, String endpoint) {
        this.vehicleClass = vehicleClass;
        this.endpoint = endpoint;
    }

    public Class<?> getVehicleClass() {
        return vehicleClass;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public static String getDescriptionByClass(Class<?> vehicleClass) {
        for (FIPEVehiclesCategories type : FIPEVehiclesCategories.values()) {
            if (type.getVehicleClass().equals(vehicleClass)) {
                return type.getEndpoint();
            }
        }
        throw new IllegalArgumentException("Cant find the vehicle type: " + vehicleClass.getName());
    }
}
