package org.example;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();

        // CREATE
        Student s1 = repo.create("Alice", 20);
        Student s2 = repo.create("Bob", 22);
        Student s3 = repo.create("Charlie", 19);
        Student s4 = repo.create("Diana", 21);
        Student s5 = repo.create("Ethan", 23);
        Student s6 = repo.create("Fiona", 18);
        System.out.println("Created: " + s1);
        System.out.println("Created: " + s2);
        System.out.println("Created: " + s3);
        System.out.println("Created: " + s4);
        System.out.println("Created: " + s5);
        System.out.println("Created: " + s6);

        // READ ALL
        System.out.println("\nAll students:");
        repo.findAll().forEach(System.out::println);

        // READ BY ID
        System.out.println("\nFind id=2: " + repo.findById(2).orElse(null));

        // UPDATE
        boolean updated = repo.update(2, "Bobby", 23);
        System.out.println("\nUpdate id=2 success: " + updated);
        System.out.println("After update: " + repo.findById(2).orElse(null));

        // DELETE
        boolean deleted = repo.delete(3);
        System.out.println("\nDelete id=3 success: " + deleted);
        System.out.println("All students after delete:");
        repo.findAll().forEach(System.out::println);
    }
}