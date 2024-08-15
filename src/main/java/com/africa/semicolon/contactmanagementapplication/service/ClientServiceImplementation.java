package com.africa.semicolon.contactmanagementapplication.service;

import com.africa.semicolon.contactmanagementapplication.data.model.Client;
import com.africa.semicolon.contactmanagementapplication.data.repository.ClientRepository;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.LogOutClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.LoginClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.RegisterClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LogOutClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LoginClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.RegisterClientResponse;
import com.africa.semicolon.contactmanagementapplication.exceptions.EmailAlreadyExistsException;
import com.africa.semicolon.contactmanagementapplication.exceptions.UserNotFoundExcetion;
import com.africa.semicolon.contactmanagementapplication.exceptions.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.africa.semicolon.contactmanagementapplication.utils.Mapper.map;
import static com.africa.semicolon.contactmanagementapplication.utils.Mapper.mapLoginResponse;

@Service
public class ClientServiceImplementation implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public RegisterClientResponse register(RegisterClientRequest registerClientRequest) {
        validateExistingClient(registerClientRequest.getEmailAddress());
        Client client = new Client();
        map(registerClientRequest, client);
        clientRepository.save(client);
        return map(client);
    }
    private void validateExistingClient(String email){
        boolean existsByEmail = clientRepository.existsByEmail(email);
        if(existsByEmail) throw new EmailAlreadyExistsException("Email already exists");
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public LoginClientResponse login(LoginClientRequest loginClientRequest) {
        Client client = clientRepository.findByEmail(loginClientRequest.getEmailAddress());
        validateClientPassword(loginClientRequest.getPassword(), client);
        client.setLoggedIn(true);
        clientRepository.save(client);
        mapLoginResponse(client);
        return mapLoginResponse(client);
    }

    @Override
    public LogOutClientResponse logOut(LogOutClientRequest logOutClientRequest) {
        Client client =  clientRepository.findByEmail(logOutClientRequest.getEmail());
        client.setLoggedIn(false);
        clientRepository.save(client);
        LogOutClientResponse logOutClientResponse = new LogOutClientResponse();
        logOutClientResponse.setMessage("Logged out successfully");
        logOutClientResponse.setLoggedIn(client.isLoggedIn());
        return logOutClientResponse;
    }

    @Override
    public Client findClientByEmail(String ownerEmail) {
        return clientRepository.findByEmail(ownerEmail);
    }

    private void validateClientPassword(String password, Client client) {
        if(!password.matches(client.getPassword())) throw new WrongPasswordException("Invalid Login Details");
    }
}
