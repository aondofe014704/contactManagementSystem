package com.africa.semicolon.contactmanagementapplication.dtos.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LogOutClientRequest {
    private String email;
}
