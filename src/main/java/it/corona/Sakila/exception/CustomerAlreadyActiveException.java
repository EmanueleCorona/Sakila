package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerAlreadyActiveException extends SakilaException {
    private static final String CUSTOMER_ALREADY_SUBSCRIBED_EXCEPTION = "Customer is already active";

    public CustomerAlreadyActiveException() {
        super(CUSTOMER_ALREADY_SUBSCRIBED_EXCEPTION);
    }
}
