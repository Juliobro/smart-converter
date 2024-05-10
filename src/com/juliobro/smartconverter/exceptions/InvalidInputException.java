package com.juliobro.smartconverter.exceptions;

public class InvalidInputException extends RuntimeException {
    private final String mensaje;

    public InvalidInputException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
