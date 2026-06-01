package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private StudentRepository repo;

    @BeforeEach
    void setUp() {
        repo = new StudentRepository();
    }

    // CREATE
    @Test
    void create_returnsStudentWithAutoIncrementedId() {
        Student s1 = repo.create("Alice", 20);
        Student s2 = repo.create("Bob", 22);

        assertEquals(1, s1.getId());
        assertEquals(2, s2.getId());
        assertEquals("Alice", s1.getName());
        assertEquals(20, s1.getAge());
    }

    // READ - findById
    @Test
    void findById_returnsStudent_whenExists() {
        Student created = repo.create("Alice", 20);
        Optional<Student> found = repo.findById(created.getId());

        assertTrue(found.isPresent());
        assertEquals(created.getId(), found.get().getId());
    }

    @Test
    void findById_returnsEmpty_whenNotExists() {
        Optional<Student> found = repo.findById(99);
        assertFalse(found.isPresent());
    }

    // READ - findAll
    @Test
    void findAll_returnsAllStudents() {
        repo.create("Alice", 20);
        repo.create("Bob", 22);
        repo.create("Charlie", 19);

        List<Student> all = repo.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void findAll_returnsEmpty_whenNoStudents() {
        assertTrue(repo.findAll().isEmpty());
    }

    // UPDATE
    @Test
    void update_modifiesStudent_whenExists() {
        Student created = repo.create("Alice", 20);
        boolean result = repo.update(created.getId(), "Alicia", 21);

        assertTrue(result);
        Student updated = repo.findById(created.getId()).get();
        assertEquals("Alicia", updated.getName());
        assertEquals(21, updated.getAge());
    }

    @Test
    void update_returnsFalse_whenNotExists() {
        boolean result = repo.update(99, "Ghost", 30);
        assertFalse(result);
    }

    // DELETE
    @Test
    void delete_removesStudent_whenExists() {
        Student created = repo.create("Alice", 20);
        boolean result = repo.delete(created.getId());

        assertTrue(result);
        assertFalse(repo.findById(created.getId()).isPresent());
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    void delete_returnsFalse_whenNotExists() {
        boolean result = repo.delete(99);
        assertFalse(result);
    }
}