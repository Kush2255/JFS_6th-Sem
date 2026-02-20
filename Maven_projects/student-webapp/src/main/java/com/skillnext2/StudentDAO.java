package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.skillnext2.Student;

public class StudentDAO {

    public static void save(Student st) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db",
                "root",
                "iare"
            );

            String sql = "INSERT INTO student(name,branch,email) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, st.getName());
            ps.setString(2, st.getBranch());
            ps.setString(3, st.getEmail());

            // 🔽 ONLY ADDED LINES
            ps.executeUpdate();
            System.out.println("STUDENT INSERT EXECUTED");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
