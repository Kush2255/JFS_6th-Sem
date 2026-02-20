package com.skillnext2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n====== STUDENT MANAGEMENT ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Branch: ");
                        String branch = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        Student s = new Student(name, branch, email);
                        dao.addStudent(s);
                        System.out.println("✅ Student Added Successfully!");
                        break;

                    case 2:
                        List<Student> list = dao.getAllStudents();
                        System.out.println("\n📌 Student List:");
                        for (Student st : list) {
                            System.out.println(st);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String uname = sc.nextLine();

                        System.out.print("Enter New Branch: ");
                        String ubranch = sc.nextLine();

                        System.out.print("Enter New Email: ");
                        String uemail = sc.nextLine();

                        Student us = new Student();
                        us.setId(uid);
                        us.setName(uname);
                        us.setBranch(ubranch);
                        us.setEmail(uemail);

                        dao.updateStudent(us);
                        System.out.println("✅ Student Updated Successfully!");
                        break;

                    case 4:
                        System.out.print("Enter Student ID to Delete: ");
                        int did = sc.nextInt();
                        dao.deleteStudent(did);
                        System.out.println("🗑 Student Deleted Successfully!");
                        break;

                    case 5:
                        System.out.println("👋 Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("❌ Invalid Choice");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
