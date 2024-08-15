package com.africa.semicolon.contactmanagementapplication.dtos.requests;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterClientRequest {
    private String emailAddress;
    private String password;
    private String username;
}
