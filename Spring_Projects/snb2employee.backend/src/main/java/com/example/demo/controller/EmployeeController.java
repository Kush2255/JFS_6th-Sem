package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {

        Employee existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(emp.getName());
            existing.setEmail(emp.getEmail());
            existing.setSalary(emp.getSalary());
            return repo.save(existing);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}