package com.skillnext2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "iare";

    // ADD STUDENT
    public void addStudent(Student st) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student (name, branch, email) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, st.getName());
        ps.setString(2, st.getBranch());
        ps.setString(3, st.getEmail());

        ps.executeUpdate();
        conn.close();
    }

    // VIEW ALL STUDENTS
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();

        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setBranch(rs.getString("branch"));
            s.setEmail(rs.getString("email"));
            list.add(s);
        }
        conn.close();
        return list;
    }

    // UPDATE STUDENT
    public void updateStudent(Student st) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql =
                "UPDATE student SET name=?, branch=?, email=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, st.getName());
        ps.setString(2, st.getBranch());
        ps.setString(3, st.getEmail());
        ps.setInt(4, st.getId());

        ps.executeUpdate();
        conn.close();
    }

    // DELETE STUDENT
    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    }
}
