package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(CustomerNotFoundException ex) {
        return getErrorMessage(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(CityNotFoundException ex) {
        return getErrorMessage(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(CustomerAlreadySubscribedException.class)
    public ResponseEntity<ErrorMessage> handleConflictException(CustomerAlreadySubscribedException ex) {
        return getErrorMessage(HttpStatus.CONFLICT, ex);
    }

    @ExceptionHandler(CustomerAlreadyActiveException.class)
    public ResponseEntity<ErrorMessage> handleConflictException(CustomerAlreadyActiveException ex) {
        return getErrorMessage(HttpStatus.CONFLICT, ex);
    }

    @ExceptionHandler(CustomerAlreadyDisabledException.class)
    public ResponseEntity<ErrorMessage> handleConflictException(CustomerAlreadyDisabledException ex) {
        return getErrorMessage(HttpStatus.CONFLICT, ex);
    }

    @ExceptionHandler(SakilaException.class)
    public ResponseEntity<ErrorMessage> handleGenericException(SakilaException ex) {
        return getErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<ErrorMessage> getErrorMessage(HttpStatus status, SakilaException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(status.value());
        errorMessage.setError(status.getReasonPhrase());
        errorMessage.setTimestamp(new Date());
        errorMessage.setDescription(ex.getLocalizedMessage());
        return ResponseEntity.status(status.value()).body(errorMessage);
    }
}
