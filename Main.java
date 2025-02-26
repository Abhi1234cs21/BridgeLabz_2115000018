package org.example;

import java.util.List;
import java.util.Arrays;

class Student {
    private String name;
    private int age;
    private List<String> subjects;

    // Constructor
    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    // toString method to display the student details
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + subjects +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a Student object
        Student student = new Student("John Doe", 20, Arrays.asList("Mathematics", "Physics", "Computer Science"));

        // Printing the Student object
        System.out.println(student);
    }
}
