package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends SakilaException {
    private static final String CUSTOMER_NOT_FOUND_EXCEPTION = "Customer not found";

    public CustomerNotFoundException() {
        super(CUSTOMER_NOT_FOUND_EXCEPTION);
    }
}
