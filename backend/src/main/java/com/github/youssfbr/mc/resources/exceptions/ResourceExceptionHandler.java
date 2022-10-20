package com.github.youssfbr.mc.resources.exceptions;

import com.github.youssfbr.mc.services.exceptions.DataIntegrityException;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationMessageError> handleValidationErrors(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map( DefaultMessageSourceResolvable::getDefaultMessage )
                .toList();

        return ResponseEntity.badRequest().body(new ValidationMessageError(messages));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError build = StandardError.builder()
                .timeStamp(Instant.now())
                .status(status.value())
                .error("Recurso inexistente.")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(build);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError build = StandardError.builder()
                .timeStamp(Instant.now())
                .status(status.value())
                .error("Não é possível excluir o recurso.")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(build);
    }

}
