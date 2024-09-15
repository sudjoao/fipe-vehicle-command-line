package com.sudjoao.vehicles_fipe.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Vehicle(@JsonProperty("codigo") String codigo, @JsonProperty("nome") String nome) {
}
