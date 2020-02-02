package com.codegrasp.demorest.controller;

import com.codegrasp.demorest.service.CustomChuckException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChuckExceptionHandler {
    @ExceptionHandler({ CustomChuckException.class })
    protected ResponseEntity<ErrorMessage> handleCustomExcption(HttpRequest req, Exception ex) {
        return new ResponseEntity<>(new ErrorMessage("Something bad happened, Chuck Norris will take care of it, please try again"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({ Exception.class })
    protected ResponseEntity<ErrorMessage> handleUnexpectedException(HttpRequest req, Exception ex) {
        return new ResponseEntity<>(new ErrorMessage("Something unexpected happened"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
