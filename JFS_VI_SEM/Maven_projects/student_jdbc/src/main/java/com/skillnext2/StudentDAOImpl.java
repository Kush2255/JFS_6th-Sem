package com.skillnext2;

import java.sql.*;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void insertStudent(Student s) throws Exception {

        String sql = "INSERT INTO student VALUES (?, ?, ?)";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());
        ps.setInt(3, s.getMarks());

        ps.executeUpdate();
        con.close();
    }

    @Override
    public void showStudents() throws Exception {

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3)
            );
        }
        con.close();
    }
}
