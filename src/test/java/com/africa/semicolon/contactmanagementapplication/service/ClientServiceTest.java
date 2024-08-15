package com.africa.semicolon.contactmanagementapplication.service;

import com.africa.semicolon.contactmanagementapplication.data.repository.ClientRepository;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.LogOutClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.LoginClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.RegisterClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LogOutClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LoginClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.RegisterClientResponse;
import com.africa.semicolon.contactmanagementapplication.exceptions.InvalidPasswordException;
import com.africa.semicolon.contactmanagementapplication.exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        clientRepository.deleteAll();
    }

    @Test
    public void testToRegisterClient(){
        RegisterClientRequest registerClientRequest = RegisterClientRequest.builder()
                .emailAddress("songujack@gmail.com")
                .password("1234567")
                .username("JackSongu01470404")
                .build();
        RegisterClientResponse registerClientResponse = clientService.register(registerClientRequest);
        assertThat(registerClientResponse).isNotNull();
        assertThat(clientService.getAllClients().size()).isEqualTo(1L);
        assertThat(registerClientResponse.getId()).isNotNull();
        assertThat(registerClientResponse.getMessage()).contains("Successfully");
    }
    @Test
    public void testToLoginClient(){
        RegisterClientRequest registerClientRequest = RegisterClientRequest.builder()
                .emailAddress("songujack@gmail.com")
                .password("1234567")
                .username("JackSongu01470404")
                .build();
        clientService.register(registerClientRequest);
        LoginClientRequest loginClientRequest = LoginClientRequest.builder()
                .emailAddress("songujack@gmail.com")
                .password("1234567")
                .build();
        LoginClientResponse loginClientResponse = clientService.login(loginClientRequest);
        assertThat(loginClientResponse).isNotNull();
        assertThat(loginClientResponse.isLoggedIn()).isTrue();
        assertThat(loginClientResponse.getMessage()).contains("Successfully");
    }
    @Test
    public void testToLoginClientWithWrongPassword_ThrowException(){
        RegisterClientRequest registerClientRequest = RegisterClientRequest.builder()
                .emailAddress("songujack@gmail.com")
                .password("1234567")
                .username("JackSongu01470404")
                .build();
        clientService.register(registerClientRequest);
        LoginClientRequest loginClientRequest = LoginClientRequest.builder()
               .emailAddress("songujack@gmail.com")
               .password("wrongPassword")
               .build();
         assertThrows(WrongPasswordException.class, () -> clientService.login(loginClientRequest));
    }
    @Test
    public void testToLogClientOut(){
        RegisterClientRequest registerClientRequest = RegisterClientRequest.builder()
                .emailAddress("songujack@gmail.com")
                .password("1234567")
                .username("JackSongu01470404")
                .build();
        clientService.register(registerClientRequest);
        LoginClientRequest loginClientRequest = LoginClientRequest.builder()
               .emailAddress("songujack@gmail.com")
               .password("1234567")
               .build();
        clientService.login(loginClientRequest);
        LogOutClientRequest logOutClientRequest = LogOutClientRequest.builder()
                .email("songujack@gmail.com")
                .build();
        LogOutClientResponse logOutClientResponse = clientService.logOut(logOutClientRequest);
        assertThat(logOutClientResponse).isNotNull();
        assertThat(logOutClientResponse.isLoggedIn()).isFalse();
        assertThat(logOutClientResponse.getMessage()).contains("Logged out successfully");
    }

}