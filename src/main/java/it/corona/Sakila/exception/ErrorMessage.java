package it.corona.Sakila.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorMessage {

    @JsonProperty
    private int status;

    @JsonProperty
    private String error;

    @JsonProperty
    private String description;

    @JsonProperty
    private Date timestamp;

}
