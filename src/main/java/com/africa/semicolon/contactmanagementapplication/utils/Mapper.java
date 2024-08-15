package com.africa.semicolon.contactmanagementapplication.utils;

import com.africa.semicolon.contactmanagementapplication.data.model.Client;
import com.africa.semicolon.contactmanagementapplication.data.model.Contact;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.CreateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.RegisterClientRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.CreateContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.LoginClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.RegisterClientResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.UpdateContactResponse;

public class Mapper {
    public static void map (RegisterClientRequest registerClientRequest, Client client){
            client.setEmail(registerClientRequest.getEmailAddress());
            client.setPassword(registerClientRequest.getPassword());
            client.setUsername(registerClientRequest.getUsername());
    }
    public static RegisterClientResponse map (Client client) {
        RegisterClientResponse registerClientResponse = new RegisterClientResponse();
        registerClientResponse.setId(client.getId());
        registerClientResponse.setUsername(client.getUsername());
        registerClientResponse.setEmailAddress(client.getEmail());
        registerClientResponse.setMessage("Successfully registered");
        return registerClientResponse;
    }
    public static LoginClientResponse mapLoginResponse(Client client){
        LoginClientResponse loginClientResponse = new LoginClientResponse();
        loginClientResponse.setEmail(client.getEmail());
        loginClientResponse.setMessage("Successfully log in");
        loginClientResponse.setLoggedIn(true);
        return loginClientResponse;
    }
    public static void mapCreateContactRequest(CreateContactRequest createContactRequest, Contact contact){
        contact.setAddress(createContactRequest.getAddress());
        contact.setFirstName(createContactRequest.getFirstName());
        contact.setPhoneNumber(createContactRequest.getPhoneNumber());
        contact.setLastName(createContactRequest.getLastName());
        contact.setEmail(createContactRequest.getEmail());
    }
    public static CreateContactResponse mapCreateContactResponse(Contact contact){
        CreateContactResponse createContactResponse = new CreateContactResponse();
        createContactResponse.setContactId(contact.getId());
        createContactResponse.setOwnerEmail(contact.getEmail());
        createContactResponse.setResponse("Contact created successfully");
        return createContactResponse;
    }
    public static UpdateContactResponse mapUpdateResponse(Contact contact){
       UpdateContactResponse updateContactResponse = new UpdateContactResponse();
       updateContactResponse.setUpdatedEmail(contact.getEmail());
       updateContactResponse.setUpdatedFirstName(contact.getFirstName());
       updateContactResponse.setUpdatedPhoneNumber(contact.getPhoneNumber());
       updateContactResponse.setUpdatedLastName(contact.getLastName());
       updateContactResponse.setUpdatedAddress(contact.getAddress());
       return updateContactResponse;
    }
}
