package com.hotel.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestController
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ExceptionFormat> resourcesNotFoundException(ResourcesNotFoundException ex , WebRequest wr){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    };

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionFormat> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wr) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionFormat> exceptionNotHandle(Exception ex, WebRequest wr) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build());
    }
}
