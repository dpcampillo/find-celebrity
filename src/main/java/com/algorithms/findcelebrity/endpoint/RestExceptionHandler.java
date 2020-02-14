package com.algorithms.findcelebrity.endpoint;

import com.algorithms.findcelebrity.domain.ErrorMessage;
import com.algorithms.findcelebrity.exception.CelebrityNotFoundException;
import com.algorithms.findcelebrity.exception.WrongFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * Handle exception
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CelebrityNotFoundException.class)
    protected ResponseEntity<ErrorMessage> handleCelebrityNotFoundException(
            CelebrityNotFoundException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(), new Date()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongFormatException.class)
    protected ResponseEntity<ErrorMessage> handleWrongFormat(
            WrongFormatException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(), new Date()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorMessage> handleGeneralError(
            Exception ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(), new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
