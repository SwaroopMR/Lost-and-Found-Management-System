package com.lostfound.servlets;

import com.lostfound.dao.UserDAO;
import com.lostfound.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");

        // Validation
        if (username == null || username.isEmpty() || email == null || email.isEmpty() || 
            password == null || password.isEmpty() || fullName == null || fullName.isEmpty()) {
            response.sendRedirect("register.jsp?error=All fields are required");
            return;
        }

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.jsp?error=Passwords do not match");
            return;
        }

        UserDAO userDAO = new UserDAO();
        
        // Check if user already exists
        if (userDAO.userExists(username)) {
            response.sendRedirect("register.jsp?error=Username already exists");
            return;
        }

        User user = new User(username, email, password, fullName, phone);
        if (userDAO.registerUser(user)) {
            response.sendRedirect("login.jsp?success=Registration successful. Please login.");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed. Please try again.");
        }
    }
}
