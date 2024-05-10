package com.juliobro.smartconverter.handlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.juliobro.smartconverter.exceptions.InvalidInputException;

public class JsonHandler {
    private JsonObject parseJsonObject(String json) {
        JsonElement jsonElement = JsonParser.parseString(json);
        return jsonElement.getAsJsonObject();
    }

    public void verificarValidez(String json) {
        JsonObject jsonObject = parseJsonObject(json);
        String resultado = jsonObject.get("result").getAsString();

        if (resultado.contains("error")) {
            throw new InvalidInputException("Ha ocurrido un error al intentar acceder a " +
                    "la información de la moneda. Por favor verifica la información ingresada.");
        }
    }

    public double extraerTasaDeConversion(String json) {
        JsonObject jsonObject = parseJsonObject(json);
        return jsonObject.get("conversion_rate").getAsDouble();
    }
}
