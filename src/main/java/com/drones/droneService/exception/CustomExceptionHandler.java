package com.drones.droneService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DispatchDroneException.class)
    public ResponseEntity<ExceptionResponse> handleDispatchDroneException(DispatchDroneException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "400", "DispatchDroneException", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
