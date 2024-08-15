package com.africa.semicolon.contactmanagementapplication.exceptions;

public class NameAlreadyExistException extends RuntimeException{
    public NameAlreadyExistException(String response){
        super(response);
    }
}
