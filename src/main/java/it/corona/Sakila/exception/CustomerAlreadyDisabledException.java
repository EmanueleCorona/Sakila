package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerAlreadyDisabledException extends SakilaException {
    private static final String CUSTOMER_ALREADY_DISABLED_EXCEPTION = "Customer is already active";

    public CustomerAlreadyDisabledException() {
        super(CUSTOMER_ALREADY_DISABLED_EXCEPTION);
    }
}
