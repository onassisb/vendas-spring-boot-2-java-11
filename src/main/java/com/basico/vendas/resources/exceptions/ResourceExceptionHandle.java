package com.basico.vendas.resources.exceptions;

import com.basico.vendas.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandle {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        var error = "recurso não encontrado";
        var status = HttpStatus.NOT_FOUND;
        var standardError = new StandardError(Instant.now(),status.value(),error,e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
