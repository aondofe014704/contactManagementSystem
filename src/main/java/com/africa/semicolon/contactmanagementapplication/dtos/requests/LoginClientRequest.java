package com.africa.semicolon.contactmanagementapplication.dtos.requests;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginClientRequest {
    private String emailAddress;
    private String password;
}
