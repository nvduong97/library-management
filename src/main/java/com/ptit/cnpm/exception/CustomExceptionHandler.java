package com.ptit.cnpm.exception;

import com.ptit.cnpm.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handlerBadRequestException(BadRequestException ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // Xử lý tất cả các exception chưa được khai báo
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception ex, WebRequest req) {
        ErrorResponse err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
