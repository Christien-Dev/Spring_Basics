package com.example.restcrudapi.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudenRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception){

        //Create Student Error response
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
        //return the response entity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exception){

        //Create Student Error response
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        //return the response entity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
