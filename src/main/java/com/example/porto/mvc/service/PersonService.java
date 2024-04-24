package com.example.porto.mvc.service;

import com.example.porto.mvc.model.Person;
import com.example.porto.mvc.repository.PersonsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    @Autowired
    private PersonsRepository personRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Person> getAllPerson() {
        List<Person> allUser = personRepository.findAll();
        return allUser;
    }

    public String createPerson(Person user) {
        try {
            personRepository.save(new Person(
                            UUID.randomUUID(),
                            user.getUsername(),
                            new Date(),
                            new Date(),
                            user.getPassword()
                    )
            );
            return "Success";
        } catch (Exception ex) {
            return "Failed :x: " + ex;
        }
    }

    public Optional<Person> findById(UUID personUUID) {
        Optional<Person> person = personRepository.findById(personUUID);
        return person;
    }

    public String deletePerson(UUID personUUID) {
        try {
            personRepository.deleteById(personUUID);
            return "Success";
        } catch (Exception ex) {
            return "Failed :x: " + ex;
        }
    }

    public String updatePerson(Person person) {
        Optional<Person> optionalPerson = findById(person.getId());

        try {
            personRepository.save(new Person(
                            person.getId() == null ? optionalPerson.get().getId() : person.getId(),
                            person.getUsername() == null ? optionalPerson.get().getUsername() : person.getUsername(),
                            person.getCreateAt() == null ? optionalPerson.get().getCreateAt() : person.getCreateAt(),
                            new Date(),
                            person.getCreateAt() == null ? optionalPerson.get().getPassword() : person.getPassword()
                    )
            );
            return "Success";
        } catch (Exception ex) {
            return "Failed :x: " + ex;
        }
    }

}
