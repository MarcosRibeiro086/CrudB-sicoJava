//manipulador de exceções rest

package com.teste.primeiroprojeto.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.primeiroprojeto.model.error.ErrorMessage;
import com.teste.primeiroprojeto.model.exception.ResourceNotFoundException;

@ControllerAdvice //controlador de error dentro da aplicação
public class RestExceptionHandler {
   
    /**
     * Caso o erro for do tipo ResourceNotFOund cria uma mensagem personalizada e devolve ela e seu status
     * @param ex
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResoucerNotFoundException(ResourceNotFoundException ex){
        ErrorMessage error=new ErrorMessage("Not found",HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
