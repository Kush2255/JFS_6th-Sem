package com.skillnext2;

import java.sql.*;

public class EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "iare";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertEmployee(Employee e) throws Exception {
        String sql = "INSERT INTO employee VALUES (?, ?, ?)";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, e.getId());
        ps.setString(2, e.getName());
        ps.setDouble(3, e.getSalary());

        ps.executeUpdate();
        con.close();
    }

    public void showEmployees() throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getDouble("salary")
            );
        }
        con.close();
    }
}
