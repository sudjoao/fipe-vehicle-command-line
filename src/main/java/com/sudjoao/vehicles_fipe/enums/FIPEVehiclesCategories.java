package com.sudjoao.vehicles_fipe.enums;

public enum FIPEVehiclesCategories {
    CAR(1, "carros"),
    MOTORCYCLE(2, "motos"),
    TRUCK(3, "caminhoes");

    private final int option;
    private final String endpoint;

    FIPEVehiclesCategories(int option, String endpoint) {
        this.option = option;
        this.endpoint = endpoint;
    }

    public int getOption(){
        return option;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public static String getDescriptionByOption(int option) {
        for (FIPEVehiclesCategories type : FIPEVehiclesCategories.values()) {
            if (option == type.option) {
                return type.getEndpoint();
            }
        }
        throw new IllegalArgumentException("Cant find the vehicle option: " + option);
    }
}
