package com.skillnext2;

public class Student {

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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Student [id=" + id +
                ", name=" + name +
                ", branch=" + branch +
                ", email=" + email + "]";
    }
}
