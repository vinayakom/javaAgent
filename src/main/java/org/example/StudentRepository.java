package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class StudentRepository {
    private final Map<Integer, Student> store = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    // CREATE
    public Student create(String name, int age) {
        var student = new Student(nextId.getAndIncrement(), name, age);
        store.put(student.id(), student);
        return student;
    }

    // READ (by id)
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    // READ (all)
    public List<Student> findAll() {
        return List.copyOf(store.values());
    }

    // UPDATE
    public boolean update(int id, String name, int age) {
        if (!store.containsKey(id)) return false;
        store.put(id, new Student(id, name, age));
        return true;
    }

    // DELETE
    public boolean delete(int id) {
        return store.remove(id) != null;
    }
}