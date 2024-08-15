package com.africa.semicolon.contactmanagementapplication.dtos.requests;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
}
