package com.juliobro.smartconverter.exceptions;

public class InvalidInputException extends RuntimeException {
    private final String MENSAJE;

    public InvalidInputException(String mensaje) {
        this.MENSAJE = mensaje;
    }

    @Override
    public String getMessage() {
        return this.MENSAJE;
    }
}
