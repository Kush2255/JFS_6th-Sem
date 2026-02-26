package com.example.demo.entity;

import java.util.Objects;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private Double salary;

    // Default Constructor
    public Employee() {
        super();
    }

    // Parameterized Constructor
    public Employee(Integer id, String name, String email, Double salary) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // toString Method
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
    }

    // hashCode Method
    @Override
    public int hashCode() {
        return Objects.hash(email, id, name, salary);
    }

    // equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(email, other.email) &&
               Objects.equals(id, other.id) &&
               Objects.equals(name, other.name) &&
               Objects.equals(salary, other.salary);
    }
}