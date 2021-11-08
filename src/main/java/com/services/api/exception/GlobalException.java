package com.services.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<ErrorObject> dataNotFoundException(NotFoundException e){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatus_code(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(e.getMessage());
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }
}
