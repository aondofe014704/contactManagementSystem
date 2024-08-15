package com.africa.semicolon.contactmanagementapplication.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareContactRequest {
    private String recieverId;
    private String senderId;
}
