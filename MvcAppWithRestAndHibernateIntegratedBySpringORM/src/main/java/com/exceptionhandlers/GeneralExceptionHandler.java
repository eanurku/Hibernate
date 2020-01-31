package com.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String defaultHandler(Exception e) {

        System.out.println("Exception occured : " + e);
        return "Exception";
    }
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullpointerExceptions(Exception e) {

        System.out.println("null pointer exception: " + e);

        return "NullPointerException";
    }
}
