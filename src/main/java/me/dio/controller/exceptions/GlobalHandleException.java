package me.dio.controller.exceptions;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalHandleException {


 private final Logger logger = LoggerFactory.getLogger(GlobalHandleException.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable unexpectedException) {
        var message = unexpectedException.getMessage();
        logger.error(message, unexpectedException);
        return new ResponseEntity<>("Unexpected server error, see the logs", HttpStatus.NOT_FOUND);
}
}
