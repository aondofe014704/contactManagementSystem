package com.africa.semicolon.contactmanagementapplication.exceptions;

public class UserNotFoundExcetion extends RuntimeException {
    public UserNotFoundExcetion(String response) {
        super(response);
    }
}
