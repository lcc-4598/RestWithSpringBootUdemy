package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOpperationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UnsupportedMathOpperationException(String exception) {
        super(exception);
    }

}
