package com.juliobro.smartconverter.connections;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestHandler {
    public String extractJson(String base, String target){
        try {
            HttpClient client = HttpClient.newHttpClient();
            String uri = "https://v6.exchangerate-api.com/v6/f432f95fc3aafca70f6438c9/pair/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri + base + "/" + target))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al conectar y extraer el json");
            return null;
        }
    }
}
