package com.africa.semicolon.contactmanagementapplication.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String response) {
        super(response);
    }
}
