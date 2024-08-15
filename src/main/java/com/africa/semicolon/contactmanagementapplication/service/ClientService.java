package com.africa.semicolon.contactmanagementapplication.service;

import com.africa.semicolon.contactmanagementapplication.data.model.Client;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.LogOutClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.LoginClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.RegisterClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LogOutClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LoginClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.RegisterClientResponse;

import java.util.Collection;
import java.util.List;

public interface ClientService {

    RegisterClientResponse register(RegisterClientRequest registerClientRequest);

    List<Client> getAllClients();

    LoginClientResponse login(LoginClientRequest loginClientRequest);

    LogOutClientResponse logOut(LogOutClientRequest logOutClientRequest);

    Client findClientByEmail(String ownerEmail);
}
