package com.example.main;

import org.hibernate.Session;
import com.example.entity.*;
import com.example.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getFactory().openSession();
        session.beginTransaction();

        Person p = new Person();
        p.setName("Krishna");

        Passport pass = new Passport();
        pass.setNumber("IND2025XYZ");

        p.setPassport(pass);
        pass.setPerson(p);

        session.persist(p);

        session.getTransaction().commit();
        session.close();

        System.out.println("Inserted Successfully!");
    }
}
