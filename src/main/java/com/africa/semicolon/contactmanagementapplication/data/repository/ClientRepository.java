package com.africa.semicolon.contactmanagementapplication.data.repository;

import com.africa.semicolon.contactmanagementapplication.data.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
    boolean existsByEmail(String email);

    Client findByEmail(String emailAddress);
}
