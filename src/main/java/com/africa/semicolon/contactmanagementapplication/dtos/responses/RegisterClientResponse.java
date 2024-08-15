package com.africa.semicolon.contactmanagementapplication.dtos.responses;

import lombok.*;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterClientResponse {
    private String id;
    private String emailAddress;
    private String message;
    private String username;
}
