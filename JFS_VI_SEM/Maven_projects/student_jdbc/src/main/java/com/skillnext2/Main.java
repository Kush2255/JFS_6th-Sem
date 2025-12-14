package com.skillnext2;

public class Main {

    public static void main(String[] args) throws Exception {

        StudentDAO dao = new StudentDAOImpl();

        Student s1 = new Student(1, "Rahul", 85);
        dao.insertStudent(s1);

        dao.showStudents();
    }
}
