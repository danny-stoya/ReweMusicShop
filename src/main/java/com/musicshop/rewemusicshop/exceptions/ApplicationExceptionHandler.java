package com.musicshop.rewemusicshop.exceptions;

import lombok.val;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MinimumAgeRequirementException.class)
    public ProblemDetail handleMinimumAgeRequirementException(MinimumAgeRequirementException e) {
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(InvalidRentPeriodException.class)
    public ProblemDetail handleInvalidRentPeriodException(InvalidRentPeriodException e) {
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ClientAlreadyExist.class)
    public ProblemDetail handleClientAlreadyExist(ClientAlreadyExist e) {
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());
    }
    //

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        val problemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());

        Map<String, String> errValues = new HashMap<>();

        for (var err : e.getBindingResult().getFieldErrors()) {
            errValues.put(err.getField(), err.getDefaultMessage());
        }

        problemDetail.setProperty("errors", errValues);
        return problemDetail;
    }
}
