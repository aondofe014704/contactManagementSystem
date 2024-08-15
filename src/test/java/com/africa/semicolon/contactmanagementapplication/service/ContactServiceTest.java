package com.africa.semicolon.contactmanagementapplication.service;

import com.africa.semicolon.contactmanagementapplication.data.model.Contact;
import com.africa.semicolon.contactmanagementapplication.data.repository.ContactRepository;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.CreateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.UpdateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.CreateContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.DeleteContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.UpdateContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ContactServiceTest {
    @Autowired
    private  ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;
    @BeforeEach
    public void setUp() {
        contactRepository.deleteAll();
    }
    @Test
    public void testToCreateAContact(){
        CreateContactRequest createContactRequest = CreateContactRequest.builder()
                .address("Lagos, Yaba, Semicolon")
                .email("songujack@gmail.com")
                .phoneNumber("08133608698")
                .lastName("Songu")
                .firstName("Jack")
                .build();
        CreateContactResponse createContactResponse = contactService.createContact(createContactRequest);
        assertThat(createContactResponse).isNotNull();
        assertThat(contactService.getAllContact()).size().isEqualTo(1L);
        assertThat(createContactResponse.getContactId()).isNotNull();
    }
    @Test
    public void testToUpdateAlreadyExistingContact(){
        CreateContactRequest createContactRequest = CreateContactRequest.builder()
                .address("Lagos, Yaba, Semicolon")
                .email("songujack@gmail.com")
                .phoneNumber("08133608698")
                .lastName("Songu")
                .firstName("Jack")
                .build();
        CreateContactResponse createContactResponse = contactService.createContact(createContactRequest);
        UpdateContactRequest updateContactRequest = UpdateContactRequest.builder()
                .id(createContactResponse.getContactId())
                .newEmail("jamesBrown@gmail.com")
                .newFirstName("PerryWizzy")
                .newLastName("KingPerry")
                .newPhoneNumber("08065099019")
                .newAddress("Surulele...Ajah")
                .build();
        UpdateContactResponse updateContactResponse = contactService.updateContact(updateContactRequest);
        assertThat(updateContactResponse).isNotNull();
        assertThat(updateContactResponse.getUpdatedEmail()).isEqualTo("jamesBrown@gmail.com");
    }
    @Test
    public void testToDeleteContact(){
        CreateContactRequest createContactRequest =  new CreateContactRequest();
                createContactRequest.setAddress("Lagos, Yaba, Semicolon");
                createContactRequest.setEmail("songujack@gmail.com");
                createContactRequest.setPhoneNumber("08133608698");
                createContactRequest.setLastName("Songu");
                createContactRequest.setFirstName("Jack");
        CreateContactResponse createContactResponse = contactService.createContact(createContactRequest);
        String contactId = createContactResponse.getContactId();
        DeleteContactResponse deleteContactResponse = contactService.deleteContact(contactId);
        assertThat(deleteContactResponse).isNotNull();
        assertThat(deleteContactResponse.getMessage().contains("Delete"));
    }
    @Test
    public void testToGetAllContact(){
        CreateContactRequest createContactRequest =  new CreateContactRequest();
        createContactRequest.setAddress("Lagos, Yaba, Semicolon");
        createContactRequest.setEmail("songujack@gmail.com");
        createContactRequest.setPhoneNumber("08133608698");
        createContactRequest.setLastName("Songu");
        createContactRequest.setFirstName("Jack");
        CreateContactResponse createContactResponse = contactService.createContact(createContactRequest);
        List<Contact> contacts =contactService.getAllContact();
        assertThat(contacts.size()).isEqualTo(1L);
    }

}