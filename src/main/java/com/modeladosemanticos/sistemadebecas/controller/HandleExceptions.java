package com.modeladosemanticos.sistemadebecas.controller;

import com.modeladosemanticos.sistemadebecas.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class HandleExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleContentNotAllowedException(MethodArgumentNotValidException unfe) {
        List<String> errors = Collections.singletonList(unfe.getMessage());

        return new ResponseEntity<>(new ErrorDTO(errors), HttpStatus.NOT_FOUND);
    }
}
