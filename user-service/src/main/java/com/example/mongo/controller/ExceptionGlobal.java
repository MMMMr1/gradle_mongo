package com.example.mongo.controller;

import com.example.mongo.core.dto.error.ExceptionErrorDTO;
import com.example.mongo.core.dto.error.ExceptionListDTO;
import com.example.mongo.core.dto.error.ExceptionStructuredDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionGlobal {

    //400 @Validated
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionListDTO> onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<ExceptionStructuredDTO> error = e.getBindingResult().getFieldErrors().stream()
                .map(s -> new ExceptionStructuredDTO(s.getField(), s.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionListDTO(error));
    }

    //    500
    @ExceptionHandler()
    public ResponseEntity<List<ExceptionErrorDTO>> onHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new ExceptionErrorDTO(e.getMessage())));
    }
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class,
            MethodArgumentConversionNotSupportedException.class})
    public ResponseEntity<List<ExceptionErrorDTO>> onArgumentTypeMismatchException(
            HttpMessageNotReadableException e ) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new ExceptionErrorDTO(e.getMessage())));
    }
    @ExceptionHandler
    public ResponseEntity<List<ExceptionErrorDTO>> handler(Throwable e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new ExceptionErrorDTO(e.getMessage())));
    }
}