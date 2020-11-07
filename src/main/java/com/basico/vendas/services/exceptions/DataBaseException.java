package com.basico.vendas.services.exceptions;

public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = 4752390210901290325L;

    public DataBaseException(String message) {
        super(message);
    }
}
