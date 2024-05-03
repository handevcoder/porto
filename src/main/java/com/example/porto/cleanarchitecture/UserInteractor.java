package com.example.porto.cleanarchitecture;

import java.util.List;

public class UserInteractor {
    private UserRepository userRepository;

    public UserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Person getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<Person> getAllUser() {
        return userRepository.findAll();
    }

    public void createUser(Person person) {
        userRepository.save(person);
    }

    public void updateUser(Person person) {
        userRepository.update(person);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

}
