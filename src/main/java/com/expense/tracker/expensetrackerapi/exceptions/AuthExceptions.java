package com.expense.tracker.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthExceptions extends RuntimeException{
    public AuthExceptions(String message){
        super(message);
    }
    public AuthExceptions(String message,Throwable cause){
        super(message, cause);
    }
    public AuthExceptions(Throwable cause){
        super(cause);
    }
}
