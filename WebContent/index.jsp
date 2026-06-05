<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lost & Found - Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Lost & Found Management</a>
            <div class="navbar-nav ml-auto">
                <% if (session.getAttribute("userId") != null) { %>
                    <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                    <a class="nav-link" href="logout.jsp">Logout</a>
                <% } else { %>
                    <a class="nav-link" href="login.jsp">Login</a>
                    <a class="nav-link" href="register.jsp">Register</a>
                <% } %>
            </div>
        </div>
    </nav>
    
    <div class="container mt-5">
        <h1>Welcome to Lost & Found Management System</h1>
        <p>A platform to report and find lost items in your community.</p>
        
        <% if (session.getAttribute("userId") == null) { %>
            <a href="register.jsp" class="btn btn-primary">Get Started</a>
        <% } else { %>
            <a href="dashboard.jsp" class="btn btn-primary">Go to Dashboard</a>
        <% } %>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>