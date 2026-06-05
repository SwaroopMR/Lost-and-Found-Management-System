package com.lostfound.servlets;

import com.lostfound.dao.ItemDAO;
import com.lostfound.models.Item;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            addItem(request, response, userId);
        } else if ("update".equals(action)) {
            updateItem(request, response);
        } else if ("delete".equals(action)) {
            deleteItem(request, response);
        }
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response, int userId) throws IOException {
        String itemName = request.getParameter("itemName");
        String itemType = request.getParameter("itemType");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String reportDateStr = request.getParameter("reportDate");

        // Validation
        if (itemName == null || itemName.isEmpty() || description == null || description.isEmpty()) {
            response.sendRedirect("post-item.jsp?error=All fields are required");
            return;
        }

        LocalDate reportDate = LocalDate.parse(reportDateStr);
        Item item = new Item(userId, itemName, itemType, description, location, reportDate);
        
        ItemDAO itemDAO = new ItemDAO();
        if (itemDAO.addItem(item)) {
            response.sendRedirect("dashboard.jsp?success=Item posted successfully");
        } else {
            response.sendRedirect("post-item.jsp?error=Failed to post item");
        }
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        String itemName = request.getParameter("itemName");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String status = request.getParameter("status");

        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName(itemName);
        item.setDescription(description);
        item.setLocation(location);
        item.setStatus(status);

        ItemDAO itemDAO = new ItemDAO();
        if (itemDAO.updateItem(item)) {
            response.sendRedirect("dashboard.jsp?success=Item updated successfully");
        } else {
            response.sendRedirect("dashboard.jsp?error=Failed to update item");
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        
        ItemDAO itemDAO = new ItemDAO();
        if (itemDAO.deleteItem(itemId)) {
            response.sendRedirect("dashboard.jsp?success=Item deleted successfully");
        } else {
            response.sendRedirect("dashboard.jsp?error=Failed to delete item");
        }
    }
}
