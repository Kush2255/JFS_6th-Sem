package com.skillnext2;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n====== STUDENT MANAGEMENT ======");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    HibernateUtil.getSessionFactory().close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void insertStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Branch: ");
        String branch = sc.next();
        System.out.print("Enter Email: ");
        String email = sc.next();

        Student s = new Student(name, branch, email);
        session.persist(s);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }

    static void viewStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();

        System.out.println("\nID | NAME | BRANCH | EMAIL");
        for (Student s : list) {
            System.out.println(s);
        }
        session.close();
    }

    static void updateStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = session.get(Student.class, id);
        if (s != null) {
            System.out.print("Enter New Name: ");
            s.setName(sc.next());
            System.out.print("Enter New Branch: ");
            s.setBranch(sc.next());
            System.out.print("Enter New Email: ");
            s.setEmail(sc.next());

            session.merge(s);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }

        tx.commit();
        session.close();
    }

    static void deleteStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = session.get(Student.class, id);
        if (s != null) {
            session.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }

        tx.commit();
        session.close();
    }
}
