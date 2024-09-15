package com.sudjoao.vehicles_fipe.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VehicleFullInfoDTO(
        @JsonProperty("TipoVeiculo") String vehicleType,
        @JsonProperty("Valor") String value,
        @JsonProperty("Marca") String brand,
        @JsonProperty("Modelo") String model,
        @JsonProperty("Combustivel") String fuel,
        @JsonProperty("AnoModelo") String modelYear,
        @JsonProperty("CodigoFipe") String fipeCode,
        @JsonProperty("MesReferencia") String referenceMonth,
        @JsonProperty("SiglaCombustivel") String fuelAcronym
) {

    @Override
    public String toString() {
        return String.format(
                "%s %s %s from the year %s, powered by %s. Its price is %s according to the FIPE table (code: %s, reference month: %s).",
                brand, model, vehicleType.toLowerCase(), modelYear, fuel.toLowerCase(), value, fipeCode, referenceMonth
        );
    }
}
