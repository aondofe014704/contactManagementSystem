package com.africa.semicolon.contactmanagementapplication.dtos.responses;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactResponse {
    private String contactId;
    private String updatedFirstName;
    private String updatedLastName;
    private String updatedEmail;
    private String updatedPhoneNumber;
    private String updatedAddress;
}
