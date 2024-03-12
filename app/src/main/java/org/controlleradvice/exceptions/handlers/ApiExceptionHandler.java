package org.controlleradvice.exceptions.handlers;

import org.controlleradvice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(final RuntimeException anException,
            final HttpServletRequest aRequest) {
        final var aMessage = "Um erro ocorreu: " + anException.getMessage();
        final var aResponse = ResponseEntity.badRequest().body(aMessage);
        return aResponse;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(final ResourceNotFoundException anException,
            final HttpServletRequest aRequest) {
        final var aMessage = anException.getMessage();
        final var aResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(aMessage);
        return aResponse;
    }

}
