package com.africa.semicolon.contactmanagementapplication.service;

import com.africa.semicolon.contactmanagementapplication.data.model.Contact;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.CreateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.UpdateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.CreateContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.DeleteContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.UpdateContactResponse;

import java.util.List;

public interface ContactService {

    CreateContactResponse createContact(CreateContactRequest createContactRequest);

    List<Contact> getAllContact();

    UpdateContactResponse updateContact(UpdateContactRequest updateContactRequest);

    DeleteContactResponse deleteContact(String contactId);
}
