package com.company.barmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BarNameTakenException extends Exception {

    public BarNameTakenException(String message) {
        super(message);
    }
}
