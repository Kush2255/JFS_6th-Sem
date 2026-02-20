package com.skillnext2;

public class App {
    public static void main(String[] args) {
        try {
            EmployeeDAO dao = new EmployeeDAO();

            Employee e1 = new Employee(101, "Rahul", 45000);
            dao.insertEmployee(e1);

            dao.showEmployees();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
