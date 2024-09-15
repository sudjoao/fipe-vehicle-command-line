package com.sudjoao.vehicles_fipe.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VehicleDTO(@JsonProperty("codigo") String codigo, @JsonProperty("nome") String nome) {
}
