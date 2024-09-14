package com.sudjoao.vehicles_fipe.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringJoiner;

public class ApiService {
    protected final HttpClient httpClient;

    public ApiService() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    public HttpResponse<String> get(String uri) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String buildParams(Map<String, String> params){
        StringJoiner query = new StringJoiner("&");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String encodedKey = URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8);
            String encodedValue = URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8);
            query.add(encodedKey + "=" + encodedValue);
        }
        return query.toString();
    }
}
