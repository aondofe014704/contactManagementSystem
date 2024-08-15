package com.africa.semicolon.contactmanagementapplication.data.repository;

import com.africa.semicolon.contactmanagementapplication.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Optional<Contact> findById(String id);

    Contact findByFirstName(String firstName);

}
