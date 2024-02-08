package com.microservices.servicioapp.exceptions;

import lombok.Setter;

@Setter
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Recurso no encontrado en el servidor");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
