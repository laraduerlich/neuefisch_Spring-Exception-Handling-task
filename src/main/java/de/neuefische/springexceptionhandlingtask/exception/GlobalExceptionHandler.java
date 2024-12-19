package de.neuefische.springexceptionhandlingtask.exception;

import de.neuefische.springexceptionhandlingtask.model.ErrorResponesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponesDTO handleException(Exception e) {
        return new ErrorResponesDTO(e.getMessage() + " (Send from Global)");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCarNotFoundException(NotFoundException e) {
        return e.getMessage() + " (Send from Global2)";
    }


}
