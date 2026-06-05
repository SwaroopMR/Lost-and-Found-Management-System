<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Lost & Found</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; align-items: center;">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow">
                    <div class="card-body p-5">
                        <h3 class="text-center mb-4">Login</h3>
                        
                        <% String error = request.getParameter("error");
                           if (error != null && !error.isEmpty()) { %>
                            <div class="alert alert-danger"><%= error %></div>
                        <% } %>
                        
                        <form action="login" method="POST">
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" name="username" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" name="password" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Login</button>
                        </form>
                        
                        <hr>
                        <p class="text-center">Don't have account? <a href="register.jsp">Register</a></p>
                        
                        <div class="alert alert-info mt-3" style="font-size: 12px;">
                            <strong>Demo:</strong><br>
                            Username: admin<br>
                            Password: admin123
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>