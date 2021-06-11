package com.api.pauta.services.exception;

public class NuloPointerException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NuloPointerException(String message) {
        super(message);
    }
}
