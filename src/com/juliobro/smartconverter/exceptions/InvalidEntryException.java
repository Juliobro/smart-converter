package com.juliobro.smartconverter.exceptions;

public class InvalidEntryException extends RuntimeException {
    private final String mensaje;

    public InvalidEntryException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
