package com.example.demo.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({JsonException.class, DepartmentNotFoundException.class})
    public ResponseEntity<Object> handleJsonException(Exception ex){
        ExceptionDetails exceptionDetails;
        if (ex instanceof JsonException) {
            exceptionDetails = new ExceptionDetails("Request is invalid");
            return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
        }
        else {
            exceptionDetails = new ExceptionDetails("Department id is invalid");
            return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
        }
    }
}
