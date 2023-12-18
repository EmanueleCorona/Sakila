package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends SakilaException {
    private static final String ADDRESS_NOT_FOUND_EXCEPTION = "Customer not found";

    public AddressNotFoundException() {
        super(ADDRESS_NOT_FOUND_EXCEPTION);
    }
}
