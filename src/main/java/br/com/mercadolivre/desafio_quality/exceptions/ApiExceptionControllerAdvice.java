package br.com.mercadolivre.desafio_quality.exceptions;

import br.com.mercadolivre.desafio_quality.exceptions.model.DefaultExceptionModel;
import br.com.mercadolivre.desafio_quality.service.exceptions.DataIntegrityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        String message = ex.getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(new DefaultExceptionModel(HttpStatus.BAD_REQUEST, message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<DefaultExceptionModel> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
        DefaultExceptionModel err = new DefaultExceptionModel(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
