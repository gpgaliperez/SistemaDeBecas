package com.modeladosemanticos.sistemadebecas.exceptions;

import com.modeladosemanticos.sistemadebecas.dto.ErrorDTO;
import com.modeladosemanticos.sistemadebecas.dto.ErroresDTO;
import com.ontotext.trree.query.functions.math.E;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class HandleExceptions extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        return new ResponseEntity(new ErroresDTO(details), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDTO> resourceNotFoundException(CustomException m) {
        ErrorDTO error = new ErrorDTO();
        error.setInfo(m.getMessage());
        return new ResponseEntity<>(new ErrorDTO(m.getMessage()), HttpStatus.NOT_FOUND);
    }
}
