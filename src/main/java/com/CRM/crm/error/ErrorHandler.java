package com.CRM.crm.error;

import com.CRM.crm.auth.exception.AuthenticationException;
import com.CRM.crm.exception.InvalidTokenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidEx(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Validation error");
        Map<String, String> validationError = new HashMap<>();
        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
            validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationError);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(InvalidTokenException.class)
    ResponseEntity<ApiError> handleInvalidTokenException(InvalidTokenException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("InvalidToken Exception");
        return ResponseEntity.status(400).body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<?> handleAuthenticationException(AuthenticationException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setPath(request.getRequestURI());
        apiError.setStatus(401);
        apiError.setMessage(exception.getMessage());
        return ResponseEntity.status(401).body(apiError);
    }


}
