package com.example.porto.mvc.repository;

import com.example.porto.mvc.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findByUsername(String username);
}
