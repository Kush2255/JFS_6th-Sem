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

    // getters & setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + branch + " | " + email;
    }
}
