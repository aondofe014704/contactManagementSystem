package com.africa.semicolon.contactmanagementapplication.dtos.responses;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginClientResponse {
    private boolean isLoggedIn;
    private String message;
    private String email;

}
