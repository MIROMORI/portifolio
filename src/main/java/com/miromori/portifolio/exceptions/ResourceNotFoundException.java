package com.miromori.portifolio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1736810910225311598L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
