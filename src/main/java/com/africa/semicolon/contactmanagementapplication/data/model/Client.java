package com.africa.semicolon.contactmanagementapplication.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Client {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private boolean isLoggedIn;
    @DBRef
    List<Contact> contacts;

}
