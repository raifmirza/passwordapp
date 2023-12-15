package com.raifmirza.passwordapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="passwords")
public class Passwords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="passwordName")
    private String passwordName;

    @Column(name="passwordhash")
    private String hashedPassword;

    @Column(name="userid")
    private int userId;

    public Passwords(){}

    public Passwords(String passwordName, String hashedPassword, int userId) {
        this.passwordName = passwordName;
        this.hashedPassword = hashedPassword;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Passwords{" +
                "id=" + id +
                ", passwordName='" + passwordName + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", userId=" + userId +
                '}';
    }
}
