package com.company.barmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsernameTakenException extends Exception {

  public UsernameTakenException(String message) {
    super(message);
  }
}
