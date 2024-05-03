package com.example.porto.cleanarchitecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<Integer, Person> users = new HashMap<>();
    private int nextId = 1;
    @Override
    public Person findById(int id) {
        return users.get(id);
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void save(Person person) {
        person.setId(nextId++);
        users.put(person.getId(), person);
    }

    @Override
    public void update(Person person) {
        if (users.containsKey(person.getId())){
            users.put(person.getId(), person);
        }

    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }
}
