package com.sudjoao.vehicles_fipe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleBrandsDTO(@JsonProperty("modelos")List<VehicleDTO> modelos) {
}
