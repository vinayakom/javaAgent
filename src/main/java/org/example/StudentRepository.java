package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentRepository {
    private final Map<Integer, Student> store = new HashMap<>();
    private int nextId = 1;

    // CREATE
    public Student create(String name, int age) {
        Student student = new Student(nextId++, name, age);
        store.put(student.getId(), student);
        return student;
    }

    // READ (by id)
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    // READ (all)
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }

    // UPDATE
    public boolean update(int id, String name, int age) {
        Student student = store.get(id);
        if (student == null) return false;
        student.setName(name);
        student.setAge(age);
        return true;
    }

    // DELETE
    public boolean delete(int id) {
        return store.remove(id) != null;
    }
}