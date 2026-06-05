<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lostfound.dao.ItemDAO" %>
<%@ page import="com.lostfound.models.Item" %>
<%@ page import="java.util.List" %>
<%
    if (session.getAttribute("userId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    Integer userId = (Integer) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
    String role = (String) session.getAttribute("role");
    ItemDAO itemDAO = new ItemDAO();
    List<Item> userItems = itemDAO.getItemsByUserId(userId);
    List<Item> allItems = itemDAO.getAllItems();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Lost & Found</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Lost & Found</a>
            <div class="navbar-nav ml-auto">
                <% if ("admin".equals(role)) { %>
                    <a class="nav-link" href="admin/dashboard.jsp">Admin Panel</a>
                <% } %>
                <a class="nav-link" href="logout.jsp">Logout</a>
            </div>
        </div>
    </nav>
    
    <div class="container mt-5">
        <h2>Welcome, <%= username %>!</h2>
        
        <div class="row mt-4">
            <div class="col-md-3">
                <div class="card text-center" style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white;">
                    <div class="card-body">
                        <h3><%= userItems.size() %></h3>
                        <p>Your Items</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center" style="background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); color: white;">
                    <div class="card-body">
                        <h3><%= allItems.size() %></h3>
                        <p>Total Items</p>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="mt-4">
            <a href="post-item.jsp" class="btn btn-primary">Post Item</a>
            <a href="search.jsp" class="btn btn-info">Search Items</a>
        </div>
        
        <h3 class="mt-5">Your Items</h3>
        <% if (userItems.isEmpty()) { %>
            <p>You haven't posted any items yet.</p>
        <% } else { %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Location</th>
                        <th>Status</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Item item : userItems) { %>
                    <tr>
                        <td><%= item.getItemName() %></td>
                        <td><%= item.getItemType() %></td>
                        <td><%= item.getLocation() %></td>
                        <td><span class="badge badge-info"><%= item.getStatus() %></span></td>
                        <td><%= item.getReportDate() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</body>
</html>