package com.africa.semicolon.contactmanagementapplication.exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String response) {
        super(response);
    }
}
