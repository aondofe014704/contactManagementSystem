package com.africa.semicolon.contactmanagementapplication.service;

import com.africa.semicolon.contactmanagementapplication.data.model.Client;
import com.africa.semicolon.contactmanagementapplication.data.model.Contact;
import com.africa.semicolon.contactmanagementapplication.data.repository.ContactRepository;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.CreateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.UpdateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.CreateContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.DeleteContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.UpdateContactResponse;
import com.africa.semicolon.contactmanagementapplication.exceptions.ContactNotFoundException;
import com.africa.semicolon.contactmanagementapplication.exceptions.UserNotFoundExcetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.africa.semicolon.contactmanagementapplication.utils.Mapper.mapCreateContactResponse;
import static com.africa.semicolon.contactmanagementapplication.utils.Mapper.mapUpdateResponse;

@Service
public class ContactServiceImplementation implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ClientService clientService;

    @Override
    public CreateContactResponse createContact(CreateContactRequest createContactRequest) {
        validateOwnerEmail(createContactRequest.getEmail());
        Contact contact = new Contact();
        contact.setPhoneNumber(createContactRequest.getPhoneNumber());
        contact.setEmail(createContactRequest.getEmail());
        contact.setFirstName(createContactRequest.getFirstName());
        contact.setLastName(createContactRequest.getLastName());
        contact.setAddress(createContactRequest.getAddress());
        mapCreateContactResponse(contact);
        contactRepository.save(contact);
        return mapCreateContactResponse(contact);

    }

    private void validateOwnerEmail(String ownerEmail) {
        Client client = clientService.findClientByEmail(ownerEmail);
        if (client == null) throw new UserNotFoundExcetion("User not found");
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public UpdateContactResponse updateContact(UpdateContactRequest updateContactRequest) {
        Optional<Contact> contact = contactRepository.findById(updateContactRequest.getId());
        Contact contact1 = new Contact();
        contact1.setEmail(updateContactRequest.getNewEmail());
        contact1.setLastName(updateContactRequest.getNewLastName());
        contact1.setFirstName(updateContactRequest.getNewLastName());
        contact1.setPhoneNumber(updateContactRequest.getNewPhoneNumber());
        contactRepository.save(contact1);
        return mapUpdateResponse(contact1);
    }

    @Override
    public DeleteContactResponse deleteContact(String contactId) {
        for (Contact contact : contactRepository.findAll()) {
            if (contact.getId().equals(contactId)) {
                DeleteContactResponse deleteContactResponse = new DeleteContactResponse();
                contactRepository.delete(contact);
                deleteContactResponse.setMessage("Successfully deleted contact");
                return deleteContactResponse;
            }
        }
        throw new ContactNotFoundException("not found contact");
    }
}
