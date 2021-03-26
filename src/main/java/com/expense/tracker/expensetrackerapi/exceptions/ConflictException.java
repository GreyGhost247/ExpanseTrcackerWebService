package com.expense.tracker.expensetrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exist")
public class ConflictException extends RuntimeException{
    public ConflictException(){}
    public ConflictException(String message){
        super(message);
    }
    public ConflictException(String message, Throwable cause){
        super(message, cause);
    }
    public ConflictException(Throwable cause){
        super(cause);
    }

}
