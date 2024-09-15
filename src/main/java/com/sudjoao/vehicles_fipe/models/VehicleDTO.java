package com.sudjoao.vehicles_fipe.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VehicleDTO(
        @JsonProperty("codigo") String code,
        @JsonProperty("nome") String name
) {
    @Override
    public String toString() {
        return String.format("Vehicle: %s (Code: %s)", name, code);
    }
}
