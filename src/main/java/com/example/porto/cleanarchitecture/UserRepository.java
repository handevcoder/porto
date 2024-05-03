package com.example.porto.cleanarchitecture;

import java.util.List;

public interface UserRepository {
    Person findById(int id);
    List<Person> findAll();
    void save(Person person);
    void update(Person person);
    void delete(int id);
}
