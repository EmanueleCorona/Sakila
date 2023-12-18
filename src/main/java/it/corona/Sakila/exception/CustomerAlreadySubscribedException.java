package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerAlreadySubscribedException extends SakilaException {
    private static final String CUSTOMER_ALREADY_SUBSCRIBED_EXCEPTION = "Customer already exists";

    public CustomerAlreadySubscribedException() {
        super(CUSTOMER_ALREADY_SUBSCRIBED_EXCEPTION);
    }
}
