package com.africa.semicolon.contactmanagementapplication.controller;

import com.africa.semicolon.contactmanagementapplication.dtos.requests.LoginClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.RegisterClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.ApiResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LoginClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.RegisterClientResponse;
import com.africa.semicolon.contactmanagementapplication.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {
    private ClientService clientService;

    @PostMapping("/api/v1/register-client")
    public ResponseEntity<?> register (@RequestBody RegisterClientRequest registerClientRequest){
        try{
            RegisterClientResponse registerClientResponse = clientService.register(registerClientRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerClientResponse), CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/api/v1/login-client")
    public ResponseEntity<?> login (@RequestBody LoginClientRequest loginClientRequest){
        try{
            LoginClientResponse loginClientResponse = clientService.login(loginClientRequest);
            return new ResponseEntity<>(new ApiResponse (true, loginClientResponse), OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse (false, exception.getMessage()),BAD_REQUEST);
        }
    }

}
