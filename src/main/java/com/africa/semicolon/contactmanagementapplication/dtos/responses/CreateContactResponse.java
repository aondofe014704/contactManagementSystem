package com.africa.semicolon.contactmanagementapplication.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactResponse {
    private String contactId;
    private String ownerEmail;
    private String response;


}
