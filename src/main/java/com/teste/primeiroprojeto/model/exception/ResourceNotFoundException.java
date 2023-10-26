package com.teste.primeiroprojeto.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
 * classe para lançar uma mensagem de 'not found'
 * response: tipo de status http da classe 
 */
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }

}
