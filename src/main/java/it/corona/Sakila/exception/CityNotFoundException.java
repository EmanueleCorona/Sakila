package it.corona.Sakila.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CityNotFoundException extends SakilaException {
    private static final String CITY_NOT_FOUND_EXCEPTION = "City not found";

    public CityNotFoundException() {
        super(CITY_NOT_FOUND_EXCEPTION);
    }
}
