package it.corona.Sakila.exception;

public class SakilaException extends RuntimeException {
    public SakilaException() {
        super();
    }

    public SakilaException(String message) {
        super(message);
    }
}
