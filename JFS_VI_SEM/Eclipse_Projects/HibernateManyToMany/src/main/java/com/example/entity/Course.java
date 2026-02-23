package com.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(mappedBy="courses")
    private List<Student> students;

    public Course() {}

    public void setTitle(String title) { this.title = title; }
}