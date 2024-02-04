package com.example.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ExceptionFormat> noHandlerFoundException(ResourcesNotFoundException ex , WebRequest wr){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionFormat> noRequestHandlerFoundException(NoHandlerFoundException ex , WebRequest wr){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionFormat> exceptionNotHandle(Exception ex , WebRequest wr){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }
}
