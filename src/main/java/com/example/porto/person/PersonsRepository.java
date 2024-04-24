package com.example.porto.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonsRepository extends JpaRepository<Person, UUID> {
}
