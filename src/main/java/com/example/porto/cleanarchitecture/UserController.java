package com.example.porto.cleanarchitecture;

import java.util.List;

public class UserController {
    private UserInteractor userInteractor;

    public UserController(UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    public Person getUserById(int id) {
        return userInteractor.getUserById(id);
    }

    public List<Person> getAllUser() {
        return userInteractor.getAllUser();
    }

    public void createdUser(Person person) {
        userInteractor.createUser(person);
    }

    public void updatedUser(Person person) {
        userInteractor.updateUser(person);
    }

    public void deletedUser(int id) {
        userInteractor.deleteUser(id);
    }


}
