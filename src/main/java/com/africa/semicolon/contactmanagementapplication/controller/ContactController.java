package com.africa.semicolon.contactmanagementapplication.controller;

import com.africa.semicolon.contactmanagementapplication.data.model.Contact;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.CreateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.requests.UpdateContactRequest;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.ApiResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.CreateContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.DeleteContactResponse;
import com.africa.semicolon.contactmanagementapplication.dtos.responses.UpdateContactResponse;
import com.africa.semicolon.contactmanagementapplication.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/contact-controller")
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;
    @PostMapping("/api/v1/create-contact")
    public ResponseEntity<?> createContact (@RequestBody CreateContactRequest createContactRequest){
        try {
            CreateContactResponse createContactResponse = contactService.createContact(createContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, createContactResponse), CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
    @PostMapping("/api/v1/update-contact")
    public ResponseEntity<?> updateContact (@RequestBody UpdateContactRequest updateContactRequest){
        try {
            UpdateContactResponse updateContactResponse = contactService.updateContact(updateContactRequest);
            return new ResponseEntity<>(new ApiResponse(true, updateContactResponse), CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse (false, exception),BAD_REQUEST);
        }
    }
    @PatchMapping("/api/v1/getAll-contact")
    public ResponseEntity<?> getAllContact(){
        try {
        List<Contact> contactList = contactService.getAllContact();
        return new ResponseEntity<>(contactList, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/v1/delete-contact")
    public ResponseEntity<?> deleteContact(@PathVariable("id") String id){
            try {
                DeleteContactResponse deleteContactResponse = contactService.deleteContact(id);
                return new ResponseEntity<>(new ApiResponse(true, deleteContactResponse), HttpStatus.OK);
            }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
            }
    }

}
