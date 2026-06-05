package com.lostfound.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Item {
    private int itemId;
    private int userId;
    private String itemName;
    private String itemType; // "lost" or "found"
    private String description;
    private String location;
    private LocalDate reportDate;
    private String imagePath;
    private String status; // "open", "claimed", "resolved"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor
    public Item() {}

    public Item(int userId, String itemName, String itemType, String description, String location, LocalDate reportDate) {
        this.userId = userId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.description = description;
        this.location = location;
        this.reportDate = reportDate;
        this.status = "open";
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", userId=" + userId +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}' ;
    }
}
