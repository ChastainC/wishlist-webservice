package com.example.demo.exception;

public class ExceptionDetails {

    private String message;

    public ExceptionDetails(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
