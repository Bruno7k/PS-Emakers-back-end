package com.emakers.api.exception.livro;

import com.emakers.api.exception.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class LivroExceptionHandler {
    @ExceptionHandler(ListOfLivrosEmptyException.class)
    private ResponseEntity<RestErrorMessage> listEmptyHandler(ListOfLivrosEmptyException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }

    @ExceptionHandler(LivroAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> livroExistHandler(LivroAlreadyExistsException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<RestErrorMessage>> methodArgumentNotValidHandler(MethodArgumentNotValidException exception){
        List<RestErrorMessage> errorMessages = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> new RestErrorMessage(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }

}
