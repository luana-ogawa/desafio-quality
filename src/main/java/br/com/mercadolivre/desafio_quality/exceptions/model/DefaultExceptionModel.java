package br.com.mercadolivre.desafio_quality.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultExceptionModel {
    private HttpStatus status;
    private String message;
}
