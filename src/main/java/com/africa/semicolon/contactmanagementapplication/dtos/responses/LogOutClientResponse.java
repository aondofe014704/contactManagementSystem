package com.africa.semicolon.contactmanagementapplication.dtos.responses;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogOutClientResponse {
    private boolean isLoggedIn;
    private String message;
}
