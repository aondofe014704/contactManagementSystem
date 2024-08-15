package com.africa.semicolon.contactmanagementapplication.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String response) {
        super(response);
    }
}
