package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Kush", "CSE", "kush@gmail.com");
        session.persist(s1);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }
}
