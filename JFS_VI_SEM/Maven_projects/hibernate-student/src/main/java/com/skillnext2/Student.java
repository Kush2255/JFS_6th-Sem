package com.skillnext2;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String branch;
    private String email;

    public Student() {}

    public Student(String name, String branch, String email) {
        this.name = name;
        this.branch = branch;
        this.email = email;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + branch + " " + email;
    }
}
