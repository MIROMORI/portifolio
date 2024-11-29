package com.miromori.portifolio.exceptions.handler;

import com.miromori.portifolio.exceptions.ExceptionResponse;
import com.miromori.portifolio.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request){
        ExceptionResponse ex = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(Exception e, WebRequest request){
        ExceptionResponse ex = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }
}
