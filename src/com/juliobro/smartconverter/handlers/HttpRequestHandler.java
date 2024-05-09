package com.juliobro.smartconverter.handlers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestHandler {
    private static final String API_KEY = "f432f95fc3aafca70f6438c9";

    public String extraerJson(String base, String target){
        try {
            HttpClient client = HttpClient.newHttpClient();
            String uri = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri + base + "/" + target))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al conectar y extraer el json");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
