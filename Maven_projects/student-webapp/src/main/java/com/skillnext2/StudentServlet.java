package com.skillnext2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Student Servlet is WORKING</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("STUDENT SERVLET doPost HIT");

        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        String email = req.getParameter("email");

        Student st = new Student();
        st.setName(name);
        st.setBranch(branch);
        st.setEmail(email);

        StudentDAO.save(st);

        // ✅ FIXED REDIRECT
        resp.sendRedirect(req.getContextPath() + "/success.jsp");

    }
}
