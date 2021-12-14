package com.example.bootweb.support.security;


import org.springframework.security.core.AuthenticationException;

public class TokenNotFoundException extends AuthenticationException {
  public TokenNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public TokenNotFoundException(String msg) {
    super(msg);
  }
}
