package com.example.phone_number_poc.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String mobileNo;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String comments;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = this.updatedAt = getCurrentDateTime();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = getCurrentDateTime();
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    // Getters only for createdAt and updatedAt
    public Long getUserId() {
        return userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    // Setters for other fields
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
}
